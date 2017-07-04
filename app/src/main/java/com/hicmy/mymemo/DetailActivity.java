package com.hicmy.mymemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hicmy.entity.Event;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Event event = (Event)intent.getSerializableExtra("detail");
        TextView d_t = (TextView) findViewById(R.id.d_title);
        TextView d_c = (TextView) findViewById(R.id.d_content);
        d_t.setText(event.getTitle());
        d_c.setText(event.getContent());
    }
}
