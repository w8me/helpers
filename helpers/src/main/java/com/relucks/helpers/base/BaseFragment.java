package com.relucks.helpers.base;

import android.widget.Toast;

import butterknife.Unbinder;

public class BaseFragment extends AndroidxFragment implements BaseView {
    protected static final String TAG = "myLog";

    protected Unbinder unbinder;
    private ProgressDialog mProgressDialog = new ProgressDialog();

    public void showToast(int id) {
        Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
    }

    public void showToast(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean status) {
        if (getActivity() != null)
            if (status)
                mProgressDialog.show(getActivity().getSupportFragmentManager(), "progress");
            else
                mProgressDialog.dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
