package com.freelance.android.practiceEC.manager;

import com.freelance.android.practiceEC.data.vos.EContactsVO;
import com.freelance.android.practiceEC.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 06/09/2016.
 */
public class DataManager {
    private static DataManager objInstance;

    public DataManager() {
    }

    private List<EContactsVO> eContactsList;

    public static DataManager getObjInstance() {
        if (objInstance == null) {
            objInstance = new DataManager();
        }
        return objInstance;
    }

    public void loadEContactsList() {
        Gson g = new Gson();
        try {
            String dummayData = JsonUtils.getInstance().loadDummyData("essential_contacts_lists.json");
            Type eContactslistType = new TypeToken<List<EContactsVO>>() {
            }.getType();
            eContactsList = g.fromJson(dummayData, eContactslistType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<EContactsVO> getEContactsList() {
        return eContactsList;
    }
}
