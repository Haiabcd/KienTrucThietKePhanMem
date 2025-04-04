package com.iuh.entity;

public class Laptop extends Computer{
    private String ram;
    private String hdd;
    private String cpu;

    public Laptop(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
    }

    @Override
    public String getRAM() {
        return "RAM FROM PC " + this.ram;
    }

    @Override
    public String getHDD() {
        return "HDD FROM PC " + this.hdd;
    }

    @Override
    public String getCPU() {
        return "CPU FROM PC " + this.cpu;
    }
}
