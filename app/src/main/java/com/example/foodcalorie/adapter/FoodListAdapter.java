package com.example.foodcalorie.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.foodcalorie.R;
import com.example.foodcalorie.model.FoodItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 29/11/2560.
 */

public class FoodListAdapter extends ArrayAdapter<FoodItem> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<FoodItem> mFoodItemList;

    public FoodListAdapter(@NonNull Context context, @LayoutRes int layoutResId, @NonNull ArrayList<FoodItem> foodItemList) {
        super(context, layoutResId, foodItemList);
        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mFoodItemList = foodItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext); // เข้าถึง object ที่เป็นตัวสูบลม
        View itemLayout = inflater.inflate(mLayoutResId, null); //อ้างไปที่ file item.xml ทั้งก้อน

        FoodItem item = mFoodItemList.get(position); //ดึงมาจากแหล้งข้อมูล

        //อ้างอิงไปที่แต่ละตัว ในitem.xml
        ImageView foodImageView = (ImageView) itemLayout.findViewById(R.id.food_image_view); //เข้าถึงวิวต่างๆที่อยู่ใน itemLayout
        TextView foodTitleTextView = (TextView) itemLayout.findViewById(R.id.food_tatle_text_view);
        TextView foodNumberTextView = (TextView) itemLayout.findViewById(R.id.food_number_text_view);

        //เอาแต่ละฟิวของitemยัดลงไป
        foodTitleTextView.setText(item.title);// set title
        foodNumberTextView.setText(item.calorie);// set calorie

        //เข้าถึงรูปภาพ---> เนื่องจากมันอยู่ในasset ฉะนั้นต้องโหลดมา (ทำแบบR.ดอเวเบิลไม่ได้)
        String pictureFileName = item.picture;
        AssetManager am = mContext.getAssets(); //เข้าถึงออปเจ็คที่ให้บริการasset
        try {
            InputStream stream = am.open(pictureFileName); //เปิดไฟล์โดยใช้AssetManager
            Drawable drawablee = Drawable.createFromStream(stream, null); //แปลงInputStreamเป็น Drawable
            foodImageView.setImageDrawable(drawablee); //set รูปภาพ

        } catch (IOException e) {
            e.printStackTrace();
        }
        //-----------------------------------------
        return itemLayout; //reture ทั้งก้อนออกไปให้ listView


    }
}
