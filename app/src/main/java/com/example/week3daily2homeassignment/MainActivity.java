package com.example.week3daily2homeassignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.week3daily2homeassignment.IntentActionConstants.CREATE_RANDOMLIST;

public class MainActivity extends AppCompatActivity implements MyBroadcastReceiverListener {

    RecyclerView recyclerView;
    ArrayList<Animal> animalArrayList = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.animalRecyclerView);

        Intent intent = new Intent(this, MyIntentService.class);
        intent.setAction(CREATE_RANDOMLIST);
        startService(intent);

        MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_be_lazy_and_sleep");
        registerReceiver(myBroadcastReceiver, intentFilter, "permission.for.this.reciever", null);


    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle passedBundle = intent.getExtras();
        if(passedBundle != null) {

            animalArrayList = passedBundle.getParcelableArrayList("animalList");
            recyclerViewAdapter = new RecyclerViewAdapter(animalArrayList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

            recyclerView.setAdapter(recyclerViewAdapter);
        }

        Toast.makeText(context, "Got The Animal List", Toast.LENGTH_LONG).show();
    }
}
