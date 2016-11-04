package com.jxx.weatherforecast.activity;

import android.content.Intent;
import android.os.Bundle;
import com.jxx.weatherforecast.R;
import com.jxx.weatherforecast.impl.NavPresenterImpl;
import com.jxx.weatherforecast.view.INavVIew;

public class NavActivity extends BaseActivity implements INavVIew{

    private NavPresenterImpl navPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
       // InitInfo();
        navPresenter = new NavPresenterImpl(NavActivity.this,this);
        navPresenter.InitInformation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }

    @Override
    public void SwitchToMainActivity() {
        Intent intent = new Intent(NavActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
