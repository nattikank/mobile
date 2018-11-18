package com.example.admin.projectmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Prograp extends AppCompatActivity {
TextView Name,Tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pro_photographer);
        Name = findViewById(R.id.photoName);
        Tel = findViewById(R.id.photoTel);
        Bundle bd = getIntent().getExtras();
        if(bd != null){
            Name.setText(bd.getString("Name"));
            Tel.setText(bd.getString("tel"));
        }

//        c_photo = findViewById(R.id.c_photo);
//
//        c_photo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), .class);
//                startActivity(intent)
//    }

    }
}