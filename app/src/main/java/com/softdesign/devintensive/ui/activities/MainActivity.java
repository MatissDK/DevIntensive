package com.softdesign.devintensive.ui.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.ConstantManager;

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String TAG = ConstantManager.TAG_PREFIX + "Main Activity";

    protected EditText mEditText;
    protected Button mRedButton, mGreenButton;
    protected int mColorMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        mEditText = (EditText) findViewById(R.id.editText);
        mRedButton = (Button) findViewById(R.id.red_btn);
        mGreenButton = (Button) findViewById(R.id.green_btn);

        mGreenButton.setOnClickListener(this);
        mRedButton.setOnClickListener(this);


        if (savedInstanceState == null) {
            //activity runs for the first time

        } else {
            //activity is already created

            mColorMode = savedInstanceState.getInt(ConstantManager.COLOR_MODE_KEY);
            if (mColorMode == Color.RED) {
                mEditText.setBackgroundColor(Color.RED);

            } else if (mColorMode == Color.GREEN) {
                mEditText.setBackgroundColor(Color.GREEN);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.green_btn:
                mEditText.setBackgroundColor(Color.GREEN);
                mColorMode = Color.GREEN;
                break;
            case R.id.red_btn:
                mEditText.setBackgroundColor(Color.RED);
                mColorMode = Color.RED;
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "onSaveInstanceState");
        outState.putInt(ConstantManager.COLOR_MODE_KEY, mColorMode);
    }
}

