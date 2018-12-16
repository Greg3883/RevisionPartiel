package com.example.bejaj.revisionpartiel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<MyObject> series = new ArrayList<MyObject>();
    private Call<MyObjectList> seriesCall;
    private RecyclerView myRecycler;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetTvShow service = RetrofitClientInstance.getRetrofitClientInstance().create(GetTvShow.class);
        seriesCall = service.getPopularTVList("39670a0475f6b455f553a71f3b19e2ba", 1,"en-EN");
        Log.i("REQUEUTE 88888888888888", seriesCall.request().url().toString());
        seriesCall.enqueue(new Callback<MyObjectList>() {
            public void onResponse(Call<MyObjectList> call, Response<MyObjectList> response) {
                generateDataList(response.body());
            }
            public void onFailure(Call<MyObjectList> call, Throwable t) {
                Log.i("888478787878778",t.getMessage());
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(MyObjectList myList) {
        myRecycler = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(myList.getShows(), this);
        myRecycler.setLayoutManager(new GridLayoutManager(this,2));
        Log.i("TAGGGGGGG","TAGGGGGGGG");
        myRecycler.setAdapter(adapter);
    }
}
