package com.fish.acfun.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fish.acfun.R;

/**
 * Created by lyjq on 2015/12/16.
 */
public class ProgressAnimBar extends RelativeLayout {
    ImageView imageView;
    TextView textView;

    AnimationDrawable animationDrawable;

    public ProgressAnimBar(Context context) {
        super(context);
    }

    public ProgressAnimBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProgressAnimBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.progressbar_anim, this);
        imageView = (ImageView) view.findViewById(R.id.image);
        textView = (TextView) view.findViewById(R.id.text);

        animationDrawable = (AnimationDrawable) imageView.getDrawable();
        textView.setText("0%");
    }

    ;

    public void start() {
        if (animationDrawable != null)
            animationDrawable.start();
    }

    public void stop() {
        if (animationDrawable != null)
            animationDrawable.stop();
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if(visibility == VISIBLE){
            start();
        }else{
            stop();
        }
    }

    public void setProgress(int percent){
        if(percent > -1 && percent < 101){
            textView.setText(percent+"%");
        }
    }
}
