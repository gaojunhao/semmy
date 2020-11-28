package com.jay.entities;

public class Logininfo {
    private String name;
    private String avasrc;

    public Logininfo(){}

    public Logininfo(String name, String avasrc) {
        this.name = name;
        this.avasrc = avasrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvasrc() {
        return avasrc;
    }

    public void setAvasrc(String avasrc) {
        this.avasrc = avasrc;
    }

    @Override
    public String toString() {
        return name + " " + avasrc;
    }
}
