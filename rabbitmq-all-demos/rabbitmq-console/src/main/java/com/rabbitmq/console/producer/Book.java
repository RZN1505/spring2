package com.rabbitmq.console.producer;

public class Book {
    private int id;
    private String desc;
    private String aut;
    public void setBookID(int i) {
        id = i;
    };
    public void setBookDescription(String d) {
        desc = d;
    };
    public void setAuthor(String a) {
        aut = a;
    };
}
