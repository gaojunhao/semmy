package com.jay.entities;

public class Encrypt {
    private String session_key;
    private String encryptedData;
    private String iv;

    public Encrypt(){}

    public Encrypt(String session_key, String encryptedData, String iv) {
        this.session_key = session_key;
        this.encryptedData = encryptedData;
        this.iv = iv;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return "{" +
                "\"session_key\":" + session_key +
                ", \"encryptedData\":\"" + encryptedData + '\"' +
                ", \"iv\":\"" + iv + '\"' +
                '}';
    }

}
