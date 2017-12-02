package com.example.foodcalorie;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.foodcalorie.adapter.FoodListAdapter;
import com.example.foodcalorie.db.FoodDbHelper;
import com.example.foodcalorie.model.FoodItem;

import java.util.ArrayList;



public class Path2 extends AppCompatActivity {


    private FoodDbHelper mHelper; //เข้าถึงฐานข้อมูล
    private SQLiteDatabase mDb; //ตัวอ้างอิงฐานข้อมูล
    private  String type;

    //สร้าง Arrylist
    private ArrayList<FoodItem> mFoodItemList = new ArrayList<>();
    private FoodListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path2);

        Intent intent = getIntent();
         type = intent.getStringExtra("type");

        mHelper = new FoodDbHelper(this);
        mDb =  mHelper.getReadableDatabase();  //เรียกmethod ReadableDatabase เพื่อเข้าถึงฐานข้อมูล
        loadDataFromDb();

        //ผูก listview กับ แหล่งข้อมูล
        mAdapter = new FoodListAdapter(
                this,
                R.layout.item,
                mFoodItemList

        );

        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(mAdapter);




    }

    private void loadDataFromDb() {
        //ดึงข้อมูลจากฐานข้อมูล
        Cursor cursor = mDb.query(  //สร้างตัวแปร cursor เพื่อมารับค่า //cursor มองว่าเแป็นตารางในฐานข้อมูล
                FoodDbHelper.TABLE_NAME,
                null, //เอาทั้งแถว
                FoodDbHelper.COL_Type + "="+type , //กรณีที่มีเเงื่อนไข "ชื่อฟิล = 1,
                //null,
                null,
                null,
                null,
                null
        );



        while (cursor.moveToNext()){ //วนloop เพื่อดึงข้อมูลในแต่ละแถว //ตัวชี้

            int id =  cursor.getInt(cursor.getColumnIndex(FoodDbHelper.COL_ID));
            String title =  cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_TITLE));
            String calorie =  cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_Calorie));
            String type =  cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_Type));
            String picture = cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_PICTURE));

            FoodItem item = new FoodItem(id, title,calorie,type,picture);//เอาทั้ง 4 ตัวเใส่ข้าไปในmodel
            mFoodItemList.add(item);

        }
    }
}
