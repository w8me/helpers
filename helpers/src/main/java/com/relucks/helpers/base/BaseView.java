package com.relucks.helpers.base;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showProgress(boolean status);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showToast(int id);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showToast(String message);

    @StateStrategyType(OneExecutionStateStrategy.class)
    default void showSoftKeyboard(View focusedView, boolean status) {
        if (focusedView == null)
            return;
        InputMethodManager imm = (InputMethodManager) focusedView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null)
            if (status) {
                focusedView.requestFocus();
                imm.showSoftInput(focusedView, 0);
            } else
                imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
    }
}
