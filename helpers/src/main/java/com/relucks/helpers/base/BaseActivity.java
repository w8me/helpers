package com.relucks.helpers.base;

import android.widget.Toast;

import butterknife.Unbinder;

public abstract class BaseActivity extends AndroidxActivity implements BaseView {

    public static final String TAG = "myLog";
    private ProgressDialog mProgressDialog = new ProgressDialog();
    protected Unbinder unbinder;

    public void showToast(int id) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }

    public void showToast(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean status) {
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog();
        try {
            if (status)
                mProgressDialog.show(getSupportFragmentManager(), "progress" + System.currentTimeMillis());
            else
                mProgressDialog.dismiss();
        }catch (Exception ignored){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }
}
