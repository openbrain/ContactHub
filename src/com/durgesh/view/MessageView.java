package com.durgesh.view;

import android.content.Context;
import android.content.Intent;

import com.durgesh.contacthub.squick.DirectAppActivity;
import com.durgesh.contacthub.squick.DirectDialActivity;
import com.durgesh.util.Constants;
import com.durgesh.view.touchlistener.GestureListener;

public class MessageView extends GestureListener {
    Context context;

    public MessageView(Context context) {
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

        Intent dialerActivity = new Intent(context, DirectDialActivity.class);
        dialerActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        dialerActivity.putExtra(Constants.SUPERQUICK, 2);
        context.startActivity(dialerActivity); 

    }

}
