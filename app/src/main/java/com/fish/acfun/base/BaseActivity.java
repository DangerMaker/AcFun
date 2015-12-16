package com.fish.acfun.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fish.acfun.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lyjq on 2015/12/14.
 */
public class BaseActivity extends AppCompatActivity {
    private Menu mMenu;

    @Nullable
    @Bind(R.id.toolbar)
    Toolbar toobar;

    @Nullable
    @Bind(R.id.ivLogo)
    ImageView ivLogo;

    @Nullable
    @Bind(R.id.toolbar_title)
    public TextView customTitle;

    public boolean mIsOnPause;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setupToolbar();
    }

    protected void setupToolbar() {
        if (toobar != null) {
            setSupportActionBar(toobar);
        }
    }


    public void setCustomTitle(String title) {
        if (customTitle != null) {
            customTitle.setText(title);
        }
    }

    public Toolbar getToobar() {
        return toobar;
    }

    public ImageView getIvLogo() {
        return ivLogo;
    }

    protected void hideTitle(boolean isVisiable) {
        if (customTitle != null) {
            customTitle.setVisibility(isVisiable ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        mIsOnPause = false;
    }

    public void onPause() {
        super.onPause();
        mIsOnPause = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
