package com.example.syl.person.model;

public class Client extends Person{

    String name_product;
    boolean VIP;

    public Client(String name, int age, String name_product, boolean vip) {
        super(name, age);
        this.name_product = name_product;
        this.VIP = vip;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }
}