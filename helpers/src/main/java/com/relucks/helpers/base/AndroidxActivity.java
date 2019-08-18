package com.relucks.helpers.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpDelegate;

@SuppressLint("Registered")
public class AndroidxActivity extends AppCompatActivity {
    private MvpDelegate<? extends MvpAppCompatActivity> mMvpDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
        getMvpDelegate().onDetach();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onDetach();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroyView();
        if (isFinishing()) {
            getMvpDelegate().onDestroy();
        }
    }

    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null)
            mMvpDelegate = new MvpDelegate(this);
        return mMvpDelegate;
    }
}
