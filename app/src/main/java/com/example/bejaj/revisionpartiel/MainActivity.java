package com.example.bejaj.revisionpartiel;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    private static final String DATABASE_NAME = "show_db";
    private ShowDatabase showDB;
    private MyObject[] objTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDB = Room.databaseBuilder(getApplicationContext(),
                ShowDatabase.class, DATABASE_NAME)
                .build();
        GetTvShow service = RetrofitClientInstance.getRetrofitClientInstance().create(GetTvShow.class);
        seriesCall = service.getPopularTVList("39670a0475f6b455f553a71f3b19e2ba", 1,"en-EN");
        Log.i("REQUEUTE 88888888888888", seriesCall.request().url().toString());
        if(isNetworkOnline())
        {
            seriesCall.enqueue(new Callback<MyObjectList>() {
                public void onResponse(Call<MyObjectList> call, final Response<MyObjectList> response) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (MyObject objet : response.body().getShows())
                            {
                                showDB.daoAccess().insertOnlySingleMovie(objet);
                            }
                        }
                    }).start();
                    generateDataList(response.body());
                }
                public void onFailure(Call<MyObjectList> call, Throwable t) {
                    Log.i("888478787878778",t.getMessage());
                    Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    objTab = showDB.daoAccess().selectAll();
                    List<MyObject> listMy = null;
                    MyObjectList objListHS = new MyObjectList(listMy);
                    for (MyObject objet : objTab) {
                        objListHS.insertObj(objet);
                    }
                    generateDataList(objListHS);
                }
            });
        }

    }

    private void generateDataList(final MyObjectList myList) {
        myRecycler = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(myList.getShows(), this);
        myRecycler.setLayoutManager(new GridLayoutManager(this,2));
        Log.i("TAGGGGGGG","TAGGGGGGGG");
        myRecycler.setAdapter(adapter);
    }

    private boolean isNetworkOnline() {
        boolean status = false;
        try{
            ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null && netInfo.getState()==NetworkInfo.State.CONNECTED) {
                status= true;
            }else {
                netInfo = cm.getNetworkInfo(1);
                if(netInfo!=null && netInfo.getState()==NetworkInfo.State.CONNECTED)
                    status= true;
            }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return status;
    }
}
