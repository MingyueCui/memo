package com.hicmy.mymemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hicmy.entity.Event;

import java.util.LinkedList;
import java.util.List;

public class ContentActivity extends AppCompatActivity {
    public static int num=0;
    public static LinkedList<Event> event_list=new LinkedList<>();//linkedlist实现了序列化接口
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        final Button okButton = (Button) findViewById(R.id.buttonOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addEvent(v);
            }
        });

    }
    public void addEvent(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText text_t = (EditText) findViewById(R.id.titleText);
        EditText text_c = (EditText) findViewById(R.id.contentText);
        String text_title = text_t.getText().toString();
        String text_content = text_c.getText().toString();
        System.out.println(text_title);
        Event event=new Event(num,text_title,text_content);
        event_list.add(event);
        intent.putExtra("event", event_list);
        Log.w("event_title",text_title);
        num++;
        startActivity(intent);
    }
}
