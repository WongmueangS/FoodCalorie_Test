package com.example.foodcalorie.model;

public class FoodItem {
    //final class อื่นอ่านได้อย่งเดียว แก้ไขมาจากข้างนอกไมไ่ได้
    public final int id;
    public final String title;
    public final String calorie;
    public final String type;
    public final String picture;

    public FoodItem(int id, String title, String calorie, String type, String picture) {
        this.id = id;
        this.title = title;
        this.calorie = calorie;
        this.type = type;
        this.picture = picture;
    }

    public String toString() {
        return title;
    }
}
