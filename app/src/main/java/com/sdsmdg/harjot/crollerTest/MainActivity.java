package com.sdsmdg.harjot.crollerTest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableFloat;

import com.sdsmdg.harjot.crollerTest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "Test";

    public ObservableFloat progress = new ObservableFloat(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        progress.set(0.8f);
    }
}
