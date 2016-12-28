package com.dxy.happy.base;

import android.os.Bundle;
import android.view.View;

import com.dxy.happy.view.ShowingPage;

public abstract class BaseShowingPageActivity extends BaseActivity {

    private ShowingPage showingPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showingPage = new ShowingPage(this) {
            @Override
            protected View createSuccessView() {
                return BaseShowingPageActivity.this.createSuccessView();
            }

            @Override
            protected void onLoad() {

            }
        };
        setContentView(showingPage);
        BaseShowingPageActivity.this.onLoad();
    }

    //继续抽象给继承自自己的Fragment
    protected abstract void onLoad();

    protected abstract View createSuccessView();

    public void showCurrentPage(ShowingPage.StateType stateType) {
        //调用showingPage的方法
        if (showingPage != null) {
            showingPage.showCurrentPage(stateType);
        }
    }
}
