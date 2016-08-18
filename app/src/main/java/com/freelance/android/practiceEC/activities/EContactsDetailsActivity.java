package com.freelance.android.practiceEC.activities;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freelance.android.practiceEC.EContactsApp;
import com.freelance.android.practiceEC.R;
import com.freelance.android.practiceEC.data.vos.EContactsVO;
import com.freelance.android.practiceEC.utils.DkkfConstants;
import com.freelance.android.practiceEC.utils.FfssConstants;
import com.freelance.android.practiceEC.utils.KwlkfConstants;
import com.freelance.android.practiceEC.utils.MccwConstants;
import com.freelance.android.practiceEC.utils.YcfsConstants;
import com.freelance.android.practiceEC.utils.YghConstants;
import com.freelance.android.practiceEC.utils.YmpfConstants;
import com.freelance.android.practiceEC.views.ViewPodFabs;

import java.util.Locale;

public class EContactsDetailsActivity extends BaseActivity implements ViewPodFabs.ControllerFabs{

    TextToSpeech tts;
    private TextView essentialTitle;
    private TextView essentialDesc;
    private TextView essentialAddress;
    private TextView essentialPhoneNo;
    private ImageView essentialstockPhoto;

    private static final String ESSENTIAL_TITLE = "ESSENTIAL_TITLE";
    private static final String ESSENTIAL_DESC = "ESSENTIAL_DESC";
    private static final String ESSENTIAL_ADDRESS = "ESSENTIAL_ADDRESS";
    private static final String ESSENTIAL_PHONENO = "ESSENTIAL_PHONENO";
    private static final String ESSENTIAL_STOCKPHOTO = "ESSENTIAL_STOCKPHOTO";

    /**
     * Static factory method in creating new intent for EssentialContactsDetailActivity.
     *
     * @param essential
     * @return
     */

    /*get essentialObject from EssentialContactsListFragment*/
    public static Intent newIntent(EContactsVO essential) {
        Intent i = new Intent(EContactsApp.getContext(), EContactsDetailsActivity.class);
        i.putExtra(ESSENTIAL_TITLE, essential.getEventTitle());
        i.putExtra(ESSENTIAL_DESC, essential.getEventDesc());
        i.putExtra(ESSENTIAL_ADDRESS, essential.getAddress());
        i.putExtra(ESSENTIAL_PHONENO, essential.getPhoneno());
        i.putExtra(ESSENTIAL_STOCKPHOTO, essential.getStockPhoto());
        return i;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_contacts_details);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        /*get essentialObject and relevant data binding */
        Intent i = getIntent();

        String title = i.getStringExtra(ESSENTIAL_TITLE);
        String desc = i.getStringExtra(ESSENTIAL_DESC);
        String address = i.getStringExtra(ESSENTIAL_ADDRESS);
        String phoneno = i.getStringExtra(ESSENTIAL_PHONENO);


        essentialTitle = (TextView) findViewById(R.id.tv_event_title);
        essentialDesc = (TextView) findViewById(R.id.tv_event_desc);
        essentialAddress = (TextView) findViewById(R.id.tv_address);
        essentialPhoneNo = (TextView) findViewById(R.id.tv_phone_no);
        essentialstockPhoto = (ImageView) findViewById(R.id.iv_stock_photo);


        essentialTitle.setText(title);
        essentialDesc.setText(desc);
        essentialAddress.setText(address);
        essentialPhoneNo.setText(phoneno);

        Glide.with(this)
                .load(getIntent().getStringExtra(ESSENTIAL_STOCKPHOTO)) //url for photo
                .centerCrop()
                .placeholder(R.drawable.empty_photo)
                .into(essentialstockPhoto);

        /*Create listener for floating action button search, call, maps, facebook and its all sent to ViewController.*/
        ViewPodFabs vpFabs = (ViewPodFabs) findViewById(R.id.vp_fabs);
        vpFabs.setController(this);

        /*Create Method for each text speak  essential Description .*/
        text2Speech();
    }

    private void text2Speech() {

        tts = new TextToSpeech(EContactsDetailsActivity.this,
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            tts.setLanguage(Locale.UK);
                        }
                    }
                });
    }

    public void speakText(View view) {
        tts.speak(essentialDesc.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onPause() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    /*get essentialTitle and linear condition for relevant phone no.*/
    @Override
    public void onTapCall() {
        Intent i = getIntent();

        String essentialTitle = i.getStringExtra(ESSENTIAL_TITLE);

        if (essentialTitle.equals("Yangon General Hospital")) {
            makeCall(YghConstants.NUMBER_TO_CALL);
        } else if (essentialTitle.equals("Myanmar Climate Change Watch")) {
            makeCall(MccwConstants.NUMBER_TO_CALL);
        } else if (essentialTitle.equals("Yangon Central Fire Station")) {
            makeCall(YcfsConstants.NUMBER_TO_CALL);
        } else if (essentialTitle.equals("Myanmar Police Force")) {
            makeCall(YmpfConstants.NUMBER_TO_CALL);
        } else if (essentialTitle.equals("Daw Khin Kyi Foundation")) {
            makeCall(DkkfConstants.NUMBER_TO_CALL);
        } else if (essentialTitle.equals("Wai Lu Kyaw Foundation")) {
            makeCall(KwlkfConstants.NUMBER_TO_CALL);
        } else {
            makeCall(FfssConstants.NUMBER_TO_CALL);
        }
    }

    /*get essentialTitle and linear condition for relevant maps.*/
    @Override
    public void onTapMap() {
        Intent i = getIntent();

        String essentialTitle = i.getStringExtra(ESSENTIAL_TITLE);

        if (essentialTitle.equals("Yangon General Hospital")) {
            navigateInMap(YghConstants.URI_TO_OPEN_IN_MAP);
        } else if (essentialTitle.equals("Myanmar Climate Change Watch")) {
            navigateInMap(MccwConstants.URI_TO_OPEN_IN_MAP);
        } else if (essentialTitle.equals("Yangon Central Fire Station")) {
            navigateInMap(YcfsConstants.URI_TO_OPEN_IN_MAP);
        } else if (essentialTitle.equals("Myanmar Police Force")) {
            navigateInMap(YmpfConstants.URI_TO_OPEN_IN_MAP);
        } else if (essentialTitle.equals("Daw Khin Kyi Foundation")) {
            navigateInMap(DkkfConstants.URI_TO_OPEN_IN_MAP);
        } else if (essentialTitle.equals("Wai Lu Kyaw Foundation")) {
            navigateInMap(KwlkfConstants.URI_TO_OPEN_IN_MAP);
        } else {
            navigateInMap(FfssConstants.URI_TO_OPEN_IN_MAP);
        }
    }

    /*get essentialTitle and linear condition for relevant facebook.*/
    @Override
    public void onTapFacebook() {
        Intent i = getIntent();

        String essentialTitle = i.getStringExtra(ESSENTIAL_TITLE);

        if (essentialTitle.equals("Yangon General Hospital")) {
            openInFacebook(YghConstants.URI_TO_OPEN_IN_FACEBOOK);
        } else if (essentialTitle.equals("Myanmar Climate Change Watch")) {
            openInFacebook(MccwConstants.URI_TO_OPEN_IN_FACEBOOK);
        } else if (essentialTitle.equals("Yangon Central Fire Station")) {
            openInFacebook(YcfsConstants.URI_TO_OPEN_IN_FACEBOOK);
        } else if (essentialTitle.equals("Myanmar Police Force")) {
            openInFacebook(YmpfConstants.URI_TO_OPEN_IN_FACEBOOK);
        } else if (essentialTitle.equals("Daw Khin Kyi Foundation")) {
            openInFacebook(DkkfConstants.URI_TO_OPEN_IN_FACEBOOK);
        } else if (essentialTitle.equals("Wai Lu Kyaw Foundation")) {
            openInFacebook(KwlkfConstants.URI_TO_OPEN_IN_FACEBOOK);
        } else {
            openInFacebook(FfssConstants.URI_TO_OPEN_IN_FACEBOOK);
        }
    }
}
