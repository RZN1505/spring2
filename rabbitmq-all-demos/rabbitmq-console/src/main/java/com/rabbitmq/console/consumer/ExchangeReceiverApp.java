package com.rabbitmq.console.consumer;

import com.rabbitmq.client.*;

public class ExchangeReceiverApp {
    private static final String EXCHANGE_NAME = "example-3";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        //String queueName = channel.queueDeclare().getQueue();
        System.out.println("My queue name: " + "123test");
        //channel.queueBind("TEST", EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume("123test", true, deliverCallback, consumerTag -> { });
    }
}
