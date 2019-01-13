package com.lxx.rear.entity;

import java.util.Random;
import java.util.UUID;

/**
 * Order
 * <p/>
 * Created by luoyingxing on 2019/1/12.
 */
public class Order {
    private String id;
    private String title;
    private String room;
    private String status;
    private String doctor;
    private String number;
    private String time;

    public static Order cloneOrder() {
        return new Order(UUID.randomUUID().toString(), "挂号预约【普通号】", "诊室：诊室1", "已过号", "号数：" + new Random().nextInt(100));
    }

    public Order() {
    }

    public Order(String id, String title, String room, String status, String number) {
        this.id = id;
        this.title = title;
        this.room = room;
        this.status = status;
        this.number = number;
    }

    public Order(String title, String room, String status, String doctor, String number, String time) {
        this.title = title;
        this.room = room;
        this.status = status;
        this.doctor = doctor;
        this.number = number;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "title='" + title + '\'' +
                ", room='" + room + '\'' +
                ", status='" + status + '\'' +
                ", doctor='" + doctor + '\'' +
                ", number='" + number + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
