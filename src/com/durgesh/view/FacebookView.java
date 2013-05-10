package com.durgesh.view;

import android.content.Context;
import android.content.Intent;

import com.durgesh.contacthub.squick.DirectAppActivity;
import com.durgesh.util.Constants;
import com.durgesh.view.touchlistener.GestureListener;

public class FacebookView extends GestureListener {
    Context context;

    public FacebookView(Context context) {
        this.context = context;
    }

    @Override
    public void onRightToLeft() {
        launchShorcut();

    }

    @Override
    public void onLeftToRight() {
        launchShorcut();

    }

    @Override
    public void onBottomToTop() {
        launchShorcut();

    }

    @Override
    public void onTopToBottom() {
        launchShorcut();

    }

    /**
     * Launch the shortcut selector base on the view on which the finger is swap
     */
    protected void launchShorcut() {

        Intent dialerActivity = new Intent(context, DirectAppActivity.class);
        dialerActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        dialerActivity.putExtra(Constants.SUPERQUICK, 4);
        context.startActivity(dialerActivity);

    }

}
