package com.ky.todo;

public class Todo {
    private int id;
    private String item;
    private boolean status;
    private String createdDate;

    public Todo() {
    }

    public Todo(String item) {
        this.item = item;
    }

    public Todo(int id, String item, boolean status, String createdDate) {
        this.id = id;
        this.item = item;
        this.status = status;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
