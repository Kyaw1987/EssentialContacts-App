package com.freelance.android.practiceEC.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.freelance.android.practiceEC.R;

public class EContactsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_contacts_list);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.yangondirectory.com/en/"));
                startActivity(i);
            }
        });

        playAudio();


    }

    private void playAudio() {
        try {
            MediaPlayer mp = null;

            if (mp == null) {
                /*this audio file is in this local resource raw folder.*/
                Uri uri = Uri.parse("android.resource://com.freelance.android.practiceEC/" + R.raw.let_her_go);
                mp = MediaPlayer.create(this, uri);
            }

            if (mp != null) {
                mp.start();
            } else {
                /*if audio file isn't have this local resource raw folder, it will show you.*/
                MessageBox("There is no audio file.");
            }
        } catch (Exception x) {
            MessageBox(x.toString());
        }
    }

    private void MessageBox(String msg) {
        new AlertDialog.Builder(this)
                .setMessage(msg)
                .setPositiveButton("OK", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_e_contacts_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
