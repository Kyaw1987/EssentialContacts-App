package com.freelance.android.practiceEC.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 06/09/2016.
 */
public class EContactsVO {

    @SerializedName("event_title")
    private String eventTitle;

    public String getEventTitle() {
        return eventTitle;
    }

    @SerializedName("stock_photo")
    private String stockPhoto;

    public String getStockPhoto() {
        return stockPhoto;
    }

    @SerializedName("event_desc")
    private String eventDesc;

    public String getEventDesc() {
        return eventDesc;
    }

    @SerializedName("address")
    private String address;

    public String getAddress() {
        return address;
    }

    @SerializedName("phone_no")
    private String phoneno;

    public String getPhoneno() {
        return phoneno;
    }
}
