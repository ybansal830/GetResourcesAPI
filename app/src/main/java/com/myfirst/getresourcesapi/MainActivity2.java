package com.myfirst.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTvName,mTvYear,mTv1,mTv2;
    private ConstraintLayout mCl;
    private ResponseResources responseResources;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        callApi();
    }

    private void callApi() {
        ApiService apiService = Network.getResources().create(ApiService.class);
        int id = Integer.parseInt(getIntent().getStringExtra("id"));
        apiService.getPosts(id).enqueue(new Callback<ResponseResources>() {
            @Override
            public void onResponse(Call<ResponseResources> call, Response<ResponseResources> response) {
                responseResources = response.body();
                setData();
            }

            @Override
            public void onFailure(Call<ResponseResources> call, Throwable t) {

            }
        });
    }

    private void setData() {
        mProgressBar.setVisibility(View.GONE);
        mTv1.setVisibility(View.VISIBLE);
        mTv2.setVisibility(View.VISIBLE);
        mTvName.setText(responseResources.getData().getName());
        mTvYear.setText(Integer.toString(responseResources.getData().getYear()));
        mCl.setBackgroundColor(Color.parseColor(responseResources.getData().getColor()));
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvName);
        mTvYear = findViewById(R.id.tvYear);
        mCl = findViewById(R.id.cl);
        mProgressBar = findViewById(R.id.progressBar);
        mTv1 = findViewById(R.id.tv1);
        mTv2 = findViewById(R.id.tv2);
    }
}