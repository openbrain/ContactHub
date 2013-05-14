package com.durgesh.view.touchlistener;

import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthError;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


/**
 * Listens Response from Library
 * 
 */

public final class ResponseListener implements DialogListener {
    Activity context;
    public ResponseListener()
    {
        
    }
    public ResponseListener(Activity context)
    {
        
      this.context =context;  
    }
    
    
    @Override
    public void onComplete(Bundle values) {

        // Variable to receive message status
        Log.d("Share-Bar", "Authentication Successful");

        // Get name of provider after authentication
        final String providerName = values.getString(SocialAuthAdapter.PROVIDER);
        Log.d("Share-Bar", "Provider Name = " + providerName);
       // Toast.makeText(ShareBarActivity.this, providerName + " connected", Toast.LENGTH_SHORT).show();

//        update = (Button) findViewById(R.id.update);
//        edit = (EditText) findViewById(R.id.editTxt);

        // Please avoid sending duplicate message. Social Media Providers
        // block duplicate messages.

//        update.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                adapter.updateStatus(edit.getText().toString());
//                Toast.makeText(ShareBarActivity.this, "Message posted on " + providerName, Toast.LENGTH_LONG)
//                        .show();
//            }
//        });
    }

    @Override
    public void onError(SocialAuthError error) {
        error.printStackTrace();
        Log.d("Share-Bar", error.getMessage());
        context.finish();
    }

    @Override
    public void onCancel() {
        Log.d("Share-Bar", "Authentication Cancelled");
    }

    @Override
    public void onBack() {
        Log.d("Share-Bar", "Dialog Closed by pressing Back Key");
        //finish the activity which started the dialog box
        //context.finish();
    }
}