package com.prosigmaka.ProjectBaru.model.dto;

public class DefaultResponse <T>{
private String massage;
private T data;

    public String getMassage() {
        return massage;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setMassage(String massage) {
        this.massage = massage;

    }
}
