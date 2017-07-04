package com.hicmy.mymemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hicmy.entity.Event;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    String[] titles =new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTitles();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView= (ListView) findViewById(R.id.list_view);
        getEvent(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lookDetail(position);
            }
        });
        final Button addButton = (Button) findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                transActivity(v);
            }
        });

    }
    public void transActivity(View view){
        Intent intent = new Intent(this, ContentActivity.class);
        startActivity(intent);
    }
    public void initTitles(){
        for(int i=0;i<20;i++)
            titles[i]="";
        titles[0]="添加新记录";
    }

    public void getEvent(ListView listView){
        Intent intent = getIntent();
        if(intent.hasExtra("event")) {
            ArrayList<Event> event_list = (ArrayList<Event>)intent.getSerializableExtra("event");
            for (int i = 0; i < event_list.size(); i++) {
                if(i<20) {
                    String title = event_list.get(i).getTitle();
                    titles[i] = title;
                }
            }
        }
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,titles);
        listView.setAdapter(adapter);
    }
    public void lookDetail(int position){
        Intent intent = getIntent();
        if(intent.hasExtra("event")) {
            ArrayList<Event> event_list = (ArrayList<Event>) intent.getSerializableExtra("event");
            Intent new_intent = new Intent(this, DetailActivity.class);
            new_intent.putExtra("detail", event_list.get(position));
            startActivity(new_intent);
        }
    }
}
