package com.example.foodcalorie.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "food.db"; //ชื่อdatabase
    private static final int DATABASE_VERSION = 1; //เวอร์ชันของ database

    public static final String TABLE_NAME = "Food";  //ชื่อตาราง
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "_title"; // ชื่ออาหาร
    public static final String COL_Calorie = "_calorie"; //ปรมาณแคลอรี่ในอาหาร
    public static final String COL_Type = "_type"; // ประเภทของอาหาร
    public static final String COL_PICTURE = "_picture"; //ภาพอาหาร

    //คำสั่งในการสร้าง table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TITLE + " TEXT, "
            + COL_Calorie + " TEXT, "
            + COL_Type + " TEXT, "
            + COL_PICTURE + " TEXT)";


    public FoodDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //ctrl + o สร้าง onCreate
    @Override
    public void onCreate(SQLiteDatabase db) { //เรียกดูว่า ฐานข้อมูลถูกสร้างหรือยัง ( ทำแค่ครั้งเดียวตอนที่ฐานข้อมูลยังไม่ถูกสร้าง )
        db.execSQL(CREATE_TABLE); //คำสั่งสร้างtable
        insertInitialData(db); //insert ข้อมูล ลงตาราง
    }

    private void insertInitialData(SQLiteDatabase db) {
        //ข้อมูล ขนมหวาน ประเภทที่ 1
        ContentValues cv = new ContentValues(); //สร้าง ContentValues
        //putค่าต่างๆใส่ลงcv
        cv.put(COL_TITLE, "กล้วยบวชชี 1 ถ้วย"); //ชื่อฟิล,ค่าที่ใส่
        cv.put(COL_Calorie, "230 Kcal");
        cv.put(COL_Type, "1");
        cv.put(COL_PICTURE, "S001.jpg");
        db.insert(TABLE_NAME, null, cv); //เอาcv ใส่ลงฐานข้อมูล

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "กุ่ยช่าย(นึ่ง) 1 ชิ้น");
        cv.put(COL_Calorie, "140 Kcal");
        cv.put(COL_Type, "1");
        cv.put(COL_PICTURE, "S002.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ขนมครก 2 คู่");
        cv.put(COL_Calorie, "210 Kcal");
        cv.put(COL_Type, "1");
        cv.put(COL_PICTURE, "S003.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ขนมชั้น 2 ชิ้น");
        cv.put(COL_Calorie, "184 Kcal");
        cv.put(COL_Type, "1");
        cv.put(COL_PICTURE, "S004.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ขนมตาล 2 กระทง");
        cv.put(COL_Calorie, "115 Kcal");
        cv.put(COL_Type, "1");
        cv.put(COL_PICTURE, "S005.jpg");
        db.insert(TABLE_NAME, null, cv);

        //---------------------------------------------
        //ข้อมูล อาหารคาว ประเภทที่ 2
        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ข้าวผัดรวมมิตรทะเล");
        cv.put(COL_Calorie, "660 Kcal");
        cv.put(COL_Type, "2");
        cv.put(COL_PICTURE, "001.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "กะเพราะไก่-ไข่ดาว");
        cv.put(COL_Calorie, "630 Kcal");
        cv.put(COL_Type, "2");
        cv.put(COL_PICTURE, "002.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ข้าวมันไก่");
        cv.put(COL_Calorie, "596 Kcal");
        cv.put(COL_Type, "2");
        cv.put(COL_PICTURE, "003.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ข้าวขาหมู");
        cv.put(COL_Calorie, "690 Kcal");
        cv.put(COL_Type, "2");
        cv.put(COL_PICTURE, "004.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ข้าวคลุกกะปิ");
        cv.put(COL_Calorie, "410 Kcal");
        cv.put(COL_Type, "2");
        cv.put(COL_PICTURE, "005.jpg");
        db.insert(TABLE_NAME, null, cv);

        //-----------------------------------------
        //ข้อมูล ผลไม้ ประเภทที่ 3
        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "กล้วยน้ำว้า 1 ผล");
        cv.put(COL_Calorie, "60 Kcal");
        cv.put(COL_Type, "3");
        cv.put(COL_PICTURE, "S001.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "กล้วยหอม 1 ผล");
        cv.put(COL_Calorie, "120 Kcal");
        cv.put(COL_Type, "3");
        cv.put(COL_PICTURE, "S002.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ขนุน 2 ยวง");
        cv.put(COL_Calorie, "60 Kcal");
        cv.put(COL_Type, "3");
        cv.put(COL_PICTURE, "S003.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ชมพู่ 2-3 ผล ");
        cv.put(COL_Calorie, "60 Kcal");
        cv.put(COL_Type, "3");
        cv.put(COL_PICTURE, "S004.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues(); //สร้าง ContentValues
        cv.put(COL_TITLE, "ทุเรียน 100 กรัม");
        cv.put(COL_Calorie, "165 Kcal");
        cv.put(COL_Type, "3");
        cv.put(COL_PICTURE, "S005.jpg");
        db.insert(TABLE_NAME, null, cv);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //สั่งให้ลบเมื่อมี table นี้อยู่
        onCreate(db); //สร้าง table ใหม่
    }

}
