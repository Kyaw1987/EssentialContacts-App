package com.freelance.android.practiceEC.utils;

import android.content.Context;

import com.freelance.android.practiceEC.EContactsApp;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 001, 1 Mar 2016.
 * This pattern is Singleton Pattern.
 * Create the json dummy data path.
 * */

public class JsonUtils {

    private static final String PATH_DUMMY_ESSENTIAL_CONTACTS = "json_dummy_data";

    private static JsonUtils objInstance;

    private Context context;

    public static JsonUtils getInstance()
    {
        if(objInstance == null)
        {
            objInstance = new JsonUtils();
        }
        return objInstance;
    }

    private JsonUtils()
    {
        context = EContactsApp.getContext();
    }

    /**
     * Read text from assets folder.
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    private byte[] readJsonFile(String fileName) throws IOException {
        InputStream inStream = context.getAssets().open(fileName);
        int size = inStream.available();
        byte[] buffer = new byte[size];
        inStream.read(buffer);
        inStream.close();
        return buffer;
    }

    /**
     * @param fileName - name of Json File.
     * @return JSONObject from loaded file.
     * @throws IOException
     * @throws JSONException
     */
    public String loadDummyData(String fileName) throws IOException, JSONException {
        byte[] buffer = readJsonFile(PATH_DUMMY_ESSENTIAL_CONTACTS + "/" + fileName);
        return new String(buffer, "UTF-8").toString();
    }
}
