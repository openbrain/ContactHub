/**Copyright (c) 2013 Durgesh Trivedi

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 3 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.durgesh.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;

import com.durgesh.R;
import com.durgesh.contacthub.squick.DirectAppActivity;
import com.durgesh.contacthub.squick.DirectDialActivity;
import com.durgesh.util.Constants;

/**
 * Abstract Class to create the View of the app and to detect the fling on the View
 * 
 * @author durgesht
 */
public abstract class SQMainVeiw extends View {
    public Context context;
    public View sqView;
    private int sqScreenWidth;
    private int sqScreenHeight;
    private static float WIDTH = 50;
    private static final int HEIGHT = 300;
    // Represent on which sqbar is swap and what shortcut it has directdial,directmessage,app or contact
    int shortcutSelector;
    WindowManager windowsmanger;
    ImageView facebook, twitter, linkdin, contact;

    public SQMainVeiw(Context context) {
        super(context);
        this.context = context;
        inflateView();
    }

    /**
     * update the view position on the screen
     */
    public abstract void updateViewParameter();

    private void inflateView() {
        windowsmanger = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        LayoutInflater view = LayoutInflater.from(context);
        sqView = view.inflate(R.layout.contacthub, null);
        // sqView.setOnTouchListener(this);
        windowsmanger.addView(sqView, makeOverlayParams());
    }

    /**
     * Set the layout parameter for the View
     * 
     * @return {@link WindowManager.LayoutParams}
     */
    protected WindowManager.LayoutParams makeOverlayParams() {
        return new WindowManager.LayoutParams(0, 0, WindowManager.LayoutParams.TYPE_SYSTEM_ALERT, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
    }

    /**
     * Update the View with Screen orientation
     * 
     * @param xAxis
     *            position of view on xAxis in case of Gravity LEFT it is not required thats why come as 0
     * @param ration
     *            give a ration to display the view at particular position(height) with screen height
     * @param gravity
     *            Gravity of the view to display on the screen
     */
    protected void updateView(int xAxis, int ration, int gravity) {
        // save screen width/height
        Display display = windowsmanger.getDefaultDisplay();
        sqScreenWidth = display.getWidth();
        sqScreenHeight = display.getHeight();
        // To give View the size according to Screen size take ration from screen size
        WindowManager.LayoutParams paramsRB = (WindowManager.LayoutParams) sqView.getLayoutParams();
        paramsRB.x = xAxis == 0 ? 0 : sqScreenWidth;
        paramsRB.y = sqScreenHeight / ration;
        applyScaling(paramsRB);
        paramsRB.height = HEIGHT;
        paramsRB.gravity = gravity;
        applyTransparency(paramsRB);
        windowsmanger.updateViewLayout(sqView, paramsRB);

    }

    /**
     * Set the Transparency for the Bar
     */
    private void applyTransparency(WindowManager.LayoutParams params) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        int transparency = settings.getInt("service_transparency", 0);
        float finalAlpha = (100f - transparency) / 100f;
        params.alpha = finalAlpha;
    }

    /**
     * Apply the scaling on the Bar
     * 
     * @param params
     */
    private void applyScaling(WindowManager.LayoutParams params) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        String size = settings.getString("service_size", "medium");
        float buttonMult = 1;
        if (size.equals("huge")) {
            buttonMult = 2f;
        } else if (size.equals("large")) {
            buttonMult = 1.5f;
        } else if (size.equals("medium")) {
            // regular size for the system
            buttonMult = 1;
        } else if (size.equals("small")) {
            buttonMult = 0.75f;
        } else if (size.equals("tiny")) {
            buttonMult = 0.5f;
        }
        params.width = (int) (WIDTH * buttonMult);
        // params.height = (int) (HEIGHT * buttonMult);
    }

    public void viewSelector(String selector) {
        if (selector.equals(context.getResources().getString(R.string.pref_lefbar_title))) {
            shortcutSelector = Constants.PHONE_CALL;
            ImageView facebookContact = (ImageView) sqView.findViewById(R.id.facebook);
            facebookContact.setOnTouchListener(new FacebookView(context));
            ImageView twitterContact = (ImageView) sqView.findViewById(R.id.twitter);
            twitterContact.setOnTouchListener(new TwitterView(context));
            ImageView linkedInContact = (ImageView) sqView.findViewById(R.id.linkedin);
            linkedInContact.setOnTouchListener(new LinkedInView(context));
            // sqView.setBackgroundResource(R.drawable.facebook);
        } else if (selector.equals(context.getResources().getString(R.string.pref_rightbare_title))) {
            shortcutSelector = Constants.MESSAGE;
            // sqView.setBackgroundResource(R.drawable.twitter);
        } else if (selector.equals(context.getResources().getString(R.string.pref_leftbottombar_title))) {
            shortcutSelector = Constants.CONTACT;
            // sqView.setBackgroundResource(R.drawable.linkedin);
        } else if (selector.equals(context.getResources().getString(R.string.pref_rightbottombar_title))) {
            shortcutSelector = Constants.APP;
            // sqView.setBackgroundResource(R.drawable.linkedin);
        }
    }

    /**
     * Return the Current view
     * 
     * @return
     */
    public View getView() {
        return sqView;
    }

    /**
     * Return the Current view
     * 
     * @return
     */
    public View setViewNull() {
        return sqView = null;
    }

}
