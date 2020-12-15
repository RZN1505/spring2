package com.rabbitmq.console.consumer;

import com.rabbitmq.client.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class JSONRecv {
    private final static String QUEUE_NAME = "123test";
    private static final String EXCHANGE_NAME = "example-3";
    private ConnectionFactory factory = null;
    private JSONParser parser;

    public JSONRecv() {
        parser = new JSONParser();
    }

    public void run() throws Exception {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            JSONObject obj = (JSONObject) parser.parse(message);

            System.out.println(" [x] Received '" + obj.toJSONString() + "'");
        }
    }
}

public class ExchangeReceiverApp {

    public static void main(String[] argv) throws Exception {
        JSONRecv test = new JSONRecv();
        test.run();
    }
}
