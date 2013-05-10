package com.durgesh.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.durgesh.contacthub.squick.DirectAppActivity;
import com.durgesh.util.Constants;
import com.durgesh.view.touchlistener.GestureListener;

public class LinkedInView extends GestureListener {
    Context context;

    public LinkedInView(Context context) {
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

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("content://contacts/people/"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        context.startActivity(intent);

    }

}
