package com.example.bejaj.revisionpartiel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyObject> series = new ArrayList<MyObject>();
    private RecyclerView myRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addSerie();
        myRecycler = (RecyclerView) findViewById(R.id.recyclerView);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));
        myRecycler.setAdapter(new MyAdapter(series));
    }

    private void addSerie() {
        series.add(new MyObject("White Gold","https://media.senscritique.com/media/000018029235/960/White_Gold.jpg"));
        series.add(new MyObject("Hero Corp","https://tel.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2FTEL.2Enews.2F2018.2F01.2F11.2F26ab0788-4307-463a-947e-5c7a33cc8b29.2Ejpeg/1150x495/crop-from/top/hero-corp-la-serie-a-besoin-de-vous-pour-sa-5e-et-derniere-saison.jpg"));
        series.add(new MyObject("Lost","https://cache.cosmopolitan.fr/data/photo/w1000_ci/58/lost-fin.jpg"));
        series.add(new MyObject("Friends","https://o.aolcdn.com/images/dims3/GLOB/legacy_thumbnail/630x315/format/jpg/quality/85/http%3A%2F%2Fi.huffpost.com%2Fgen%2F1776643%2Fimages%2Fn-FRIENDS-628x314.jpg"));
        series.add(new MyObject("Narcos","https://o.aolcdn.com/images/dims3/GLOB/crop/1829x915+0+168/resize/630x315!/format/jpg/quality/85/http%3A%2F%2Fo.aolcdn.com%2Fhss%2Fstorage%2Fmidas%2F932233fa8db54df0197c96d310fbbe0b%2F206220085%2F128229.jpg-r_1920_1080-f_jpg-q_x-xxyxx.jpg"));
        series.add(new MyObject("Mindhunter","https://www.telerama.fr/sites/tr_master/files/styles/simplecrop1000/public/mind_0.jpg?itok=9sg7gWwz&sc=ceb35790cb42ccb262393c41d081375f"));
    }
}
