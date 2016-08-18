package com.freelance.android.practiceEC.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

import com.freelance.android.practiceEC.R;
import com.freelance.android.practiceEC.controllers.BaseController;
import com.freelance.android.practiceEC.controllers.ViewController;

/**
 * Created by Administrator on 002, 7 Mar 2016.
 */
public class ViewPodFabs extends FrameLayout implements ViewController {

    private FloatingActionButton fabSearch;
    private FloatingActionButton fabCall;
    private FloatingActionButton fabMap;
    private FloatingActionButton fabFacebook;

    private ControllerFabs controller;

    private boolean isOpen = false;

    public ViewPodFabs(Context context) {
        super(context);
    }

    public ViewPodFabs(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPodFabs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*Create Method for floating action button of serach open animation*/
    private void openAnim() {
        ObjectAnimator objAnimRotation = ObjectAnimator.ofFloat(fabSearch, "rotation", 540f, 0f);
        objAnimRotation.setDuration(600);
        objAnimRotation.setInterpolator(new AccelerateInterpolator());
        objAnimRotation.start();

        ObjectAnimator objAnimCallFW = ObjectAnimator.ofFloat(fabCall, "y", fabCall.getY(), fabCall.getY() + 310f);
        objAnimCallFW.setDuration(500);
        objAnimCallFW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimCallBW = ObjectAnimator.ofFloat(fabCall, "y", fabCall.getY() + 310, fabCall.getY() + 280f);
        objAnimCallBW.setDuration(100);
        objAnimCallBW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asCall = new AnimatorSet();
        asCall.play(objAnimCallBW).after(objAnimCallFW);
        asCall.start();

        ObjectAnimator objAnimFacebookFW = ObjectAnimator.ofFloat(fabFacebook, "x", fabFacebook.getX(), fabFacebook.getX() + 310f);
        objAnimFacebookFW.setDuration(500);
        objAnimFacebookFW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimFacebookBW = ObjectAnimator.ofFloat(fabFacebook, "x", fabFacebook.getX() + 310, fabFacebook.getX() + 280f);
        objAnimFacebookBW.setDuration(100);
        objAnimFacebookBW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asFacebook = new AnimatorSet();
        asFacebook.play(objAnimFacebookBW).after(objAnimFacebookFW);
        asFacebook.start();

        ObjectAnimator objAnimMapXFW = ObjectAnimator.ofFloat(fabMap, "x", fabMap.getX(), fabMap.getX() + 180f);
        objAnimMapXFW.setDuration(500);
        objAnimMapXFW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimMapYFW = ObjectAnimator.ofFloat(fabMap, "y", fabMap.getY(), fabMap.getY() + 180f);
        objAnimMapYFW.setDuration(500);
        objAnimMapYFW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asMapFW = new AnimatorSet();
        asMapFW.play(objAnimMapYFW).with(objAnimMapXFW);
        asMapFW.start();

        ObjectAnimator objAnimMapXBW = ObjectAnimator.ofFloat(fabMap, "x", fabMap.getX() + 180f, fabMap.getX() + 160f);
        objAnimMapXBW.setDuration(100);
        objAnimMapXBW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimMapYBW = ObjectAnimator.ofFloat(fabMap, "y", fabMap.getY() + 180f, fabMap.getY() + 160f);
        objAnimMapYBW.setDuration(100);
        objAnimMapYBW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asMapBW = new AnimatorSet();
        asMapBW.play(objAnimMapYBW).with(objAnimMapXBW);
        asMapBW.setStartDelay(500);
        asMapBW.start();
    }

    /*Create Method for floating action button of serach close animation*/
    private void closeAnim() {
        ObjectAnimator objAnimRotation = ObjectAnimator.ofFloat(fabSearch, "rotation", 0, 540f);
        objAnimRotation.setDuration(600);
        objAnimRotation.setInterpolator(new AccelerateInterpolator());
        objAnimRotation.start();

        ObjectAnimator objAnimCallFW = ObjectAnimator.ofFloat(fabCall, "y", fabCall.getY(), fabCall.getY() - 30f);
        objAnimCallFW.setDuration(100);
        objAnimCallFW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimCallBW = ObjectAnimator.ofFloat(fabCall, "y", fabCall.getY() + 30, fabCall.getY() - 280f);
        objAnimCallBW.setDuration(500);
        objAnimCallBW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asCall = new AnimatorSet();
        asCall.play(objAnimCallBW).after(objAnimCallFW);
        asCall.start();

        ObjectAnimator objAnimFacebookFW = ObjectAnimator.ofFloat(fabFacebook, "x", fabFacebook.getX(), fabFacebook.getX() + 30f);
        objAnimFacebookFW.setDuration(100);
        objAnimFacebookFW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimFacebookBW = ObjectAnimator.ofFloat(fabFacebook, "x", fabFacebook.getX() + 30, fabFacebook.getX() - 280f);/*original is +*/
        objAnimFacebookBW.setDuration(500);
        objAnimFacebookBW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asFacebook = new AnimatorSet();
        asFacebook.play(objAnimFacebookBW).after(objAnimFacebookFW);
        asFacebook.start();

        ObjectAnimator objAnimMapXFW = ObjectAnimator.ofFloat(fabMap, "x", fabMap.getX(), fabMap.getX() + 20);
        objAnimMapXFW.setDuration(100);
        objAnimMapXFW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimMapYFW = ObjectAnimator.ofFloat(fabMap, "y", fabMap.getY(), fabMap.getY() + 20);
        objAnimMapYFW.setDuration(100);
        objAnimMapYFW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asMapFW = new AnimatorSet();
        asMapFW.play(objAnimMapYFW).with(objAnimMapXFW);
        asMapFW.start();

        ObjectAnimator objAnimMapXBW = ObjectAnimator.ofFloat(fabMap, "x", fabMap.getX() + 20f, fabMap.getX() - 160f);/*original is +*/
        objAnimMapXBW.setDuration(500);
        objAnimMapXBW.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objAnimMapYBW = ObjectAnimator.ofFloat(fabMap, "y", fabMap.getY() + 20f, fabMap.getY() - 160f);/*original is +*/
        objAnimMapYBW.setDuration(500);
        objAnimMapYBW.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet asMapBW = new AnimatorSet();
        asMapBW.play(objAnimMapYBW).with(objAnimMapXBW);
        asMapBW.setStartDelay(100);
        asMapBW.start();
    }

    /*The parenthesized (floatingActionButton) is a cast. Create setOnClickListener event for fabCall, fabMap and fabFacebook*/
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        fabSearch = (FloatingActionButton) findViewById(R.id.fab_search);
        fabSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    openAnim();
                    isOpen = true;
                } else {
                    closeAnim();
                    isOpen = false;
                }
            }
        });

        fabCall = (FloatingActionButton) findViewById(R.id.fab_call);
        fabCall.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onTapCall();
            }
        });

        fabMap = (FloatingActionButton) findViewById(R.id.fab_map);
        fabMap.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onTapMap();
            }
        });

        fabFacebook = (FloatingActionButton) findViewById(R.id.fab_facebook);
        fabFacebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onTapFacebook();
            }
        });
    }

    @Override
    public void setController(BaseController controller) {
        this.controller = (ControllerFabs) controller;
    }

    /*Inherited and its all sent from ViewController to BaseController.*/
    public interface ControllerFabs extends BaseController {
        void onTapCall();

        void onTapMap();

        void onTapFacebook();
    }
}