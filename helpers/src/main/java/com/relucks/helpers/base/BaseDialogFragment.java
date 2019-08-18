package com.relucks.helpers.base;

import android.app.Dialog;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.Unbinder;

public class BaseDialogFragment extends AndroidxDialogFragment implements BaseView {

    protected static final String TAG = "myLog";
    private ProgressDialog mProgressDialog = new ProgressDialog();
    protected Unbinder unbinder;

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
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            unbinder.unbind();
        } catch (Exception ignored) {

        }
    }
}
