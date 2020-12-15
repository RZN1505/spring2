package com.rabbitmq.console.producer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.simple.JSONObject;


class JSONSend {
    private final static String QUEUE_NAME = "123test";
    private ConnectionFactory factory = null;
    private static final String EXCHANGE_NAME = "example-3";

    public JSONSend() {
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
    public void run() throws Exception {
        factory = new ConnectionFactory();
        factory.setHost("localhost");

        System.out.println("connected to rabbitMQ on localhost ...");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        for (int i = 1; i <= 10; i++) {
            JSONObject obj = new JSONObject();

            obj.put("name", String.format("Person%s", i));
            obj.put("age", new Integer(37));
            obj.put("star", new Integer(57));

            channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, obj.toJSONString().getBytes());
            System.out.println(" [x] Sent '" + obj.toJSONString() + "'");
        }

        channel.close();
        connection.close();
    }
}
    public class ExchangeSenderApp {

    public static void main(String[] argv) throws Exception {
        JSONSend test = new JSONSend();
        test.run();
    }
}