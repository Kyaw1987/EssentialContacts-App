package com.freelance.android.practiceEC.views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freelance.android.practiceEC.R;
import com.freelance.android.practiceEC.data.vos.EContactsVO;

/**
 * Created by Administrator on 002, 2 Mar 2016.
 */
public class ViewItemEssential extends CardView {

    private TextView tvEventTitle;
    private ImageView ivStockPhoto;
    private TextView tvEventDesc;


    public ViewItemEssential(Context context) {
        super(context);
    }

    public ViewItemEssential(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemEssential(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*The parenthesized (TextView) and (ImageView) is a cast.*/
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvEventTitle = (TextView)findViewById(R.id.tv_event_title);
        ivStockPhoto = (ImageView)findViewById(R.id.iv_stock_photo);
        tvEventDesc = (TextView)findViewById(R.id.tv_event_desc);
    }

    /*relevant data binding for view_item_e_contacts.xml*/
    public void setData(EContactsVO essential) {
        tvEventTitle.setText(essential.getEventTitle());
        tvEventDesc.setText(essential.getEventDesc());

        Glide.with(getContext())
                .load(essential.getStockPhoto()) //url for photo
                .centerCrop()
                .placeholder(R.drawable.empty_photo)
                .into(ivStockPhoto);
    }
}