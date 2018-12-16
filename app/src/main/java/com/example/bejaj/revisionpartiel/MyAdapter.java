package com.example.bejaj.revisionpartiel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import static android.content.ContentValues.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {

    private List<MyObject> list;
    private Activity activity;

    public MyAdapter(List<MyObject> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards,viewGroup,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {
        MyObject myObject = list.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick ");
        Intent serieDetailIntent = new Intent(activity, SerieDetailActivity.class);
        activity.startActivity(serieDetailIntent);
    }
}
