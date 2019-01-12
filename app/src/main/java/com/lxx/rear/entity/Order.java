package com.lxx.rear.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 * <p/>
 * Created by luoyingxing on 2019/1/12.
 */
public class Order {
    private String title;
    private String room;
    private String status;
    private String doctor;
    private String number;
    private String time;

    public static List<Order> getOrders() {
        List<Order> list = new ArrayList<>();
        list.add(new Order("挂号预约【普通号】", "诊室：诊室1", "已过号", "医生：李桂春", "号数：91", "就诊时间：2019-01-06 14:15 - 15:30"));
        list.add(new Order("挂号预约【普通号】", "诊室：诊室2", "已过号", "医生：房秀兰", "号数：11", "就诊时间：2018-11-22 08:00 - 10:00"));
        list.add(new Order("挂号预约【普通号】", "诊室：诊室1", "已过号", "医生：孔润萍", "号数：22", "就诊时间：2018-09-14 15:30 - 16:30"));
        return list;
    }

    public Order() {
    }

    public Order(String title, String room, String status, String doctor, String number, String time) {
        this.title = title;
        this.room = room;
        this.status = status;
        this.doctor = doctor;
        this.number = number;
        this.time = time;
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
}
