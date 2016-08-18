package com.freelance.android.practiceEC.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.freelance.android.practiceEC.R;
import com.freelance.android.practiceEC.activities.EContactsDetailsActivity;
import com.freelance.android.practiceEC.data.vos.EContactsVO;
import com.freelance.android.practiceEC.manager.DataManager;
import com.freelance.android.practiceEC.views.ViewItemEssential;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class EContactsListFragment extends Fragment {

    public EContactsListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_e_contacts, container, false);

        LinearLayout llEssentialRoot = (LinearLayout)rootView.findViewById(R.id.ll_e_contacts_root);

        List<EContactsVO> essentialList = DataManager.getObjInstance().getEContactsList();
        for (final EContactsVO essential : essentialList) {
            ViewItemEssential viEssential = (ViewItemEssential)inflater.inflate(R.layout.view_item_e_contacts, container, false);
            viEssential.setData(essential);

            viEssential.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = EContactsDetailsActivity.newIntent(essential);
                    startActivity(i);
                }
            });

            llEssentialRoot.addView(viEssential);
        }
        return rootView;
    }
}
