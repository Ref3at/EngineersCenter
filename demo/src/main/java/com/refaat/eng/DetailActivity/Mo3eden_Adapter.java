package com.refaat.eng.DetailActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.refaat.eng.R;

import java.util.List;

/**
 * Created by ogaclejapan on 2/15/2016.
 */
public class Mo3eden_Adapter extends ArrayAdapter {
    public Mo3eden_Adapter(Context context, List<Mo3eed> mo3eedsParamses) {
        super(context, 0, mo3eedsParamses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position


        Mo3eed mo3eed = (Mo3eed) getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mo3deen_cardview, parent, false);
        }

        TextView nm, sh7, morg3a, emtyanat, sheet, section, notes;
        nm = (TextView) convertView.findViewById(R.id.mo3eedmn);
        sh7 = (TextView) convertView.findViewById(R.id.shr7);
        morg3a = (TextView) convertView.findViewById(R.id.morg);
        section = (TextView) convertView.findViewById(R.id.sec);
        sheet = (TextView) convertView.findViewById(R.id.shet);
        emtyanat = (TextView) convertView.findViewById(R.id.emt7anat);
        notes = (TextView) convertView.findViewById(R.id.notes);

        LinearLayout l1, l2, l3, l4, l5, l6;
        l1 = (LinearLayout) convertView.findViewById(R.id.l1);
        l2 = (LinearLayout) convertView.findViewById(R.id.l2);
        l3 = (LinearLayout) convertView.findViewById(R.id.l3);
        l4 = (LinearLayout) convertView.findViewById(R.id.l4);
        l5 = (LinearLayout) convertView.findViewById(R.id.l5);
        l6 = (LinearLayout) convertView.findViewById(R.id.l6);


        nm.setText(mo3eed.getMo3eedname());

        if (mo3eed.getHasshr7numb()) {
            sh7.setText(mo3eed.getShr7numb());
        } else {
            l1.setVisibility(View.GONE);
        }
        if (mo3eed.getHasmorag3anum()) {
            morg3a.setText(mo3eed.getMorag3anum());
        } else {
            l2.setVisibility(View.GONE);
        }
        if (mo3eed.getHassectionsnum()) {
            section.setText(mo3eed.getSectionsnum());
        } else {
            l3.setVisibility(View.GONE);
        }
        if (mo3eed.getHassheetnumb()) {
            sheet.setText(mo3eed.getSheetnumb());
        } else {
            l4.setVisibility(View.GONE);
        }

        if (mo3eed.getHasemt7anatnum()) {
            emtyanat.setText(mo3eed.getEmt7anatnum());
        } else {
            l5.setVisibility(View.GONE);
        }
        if (mo3eed.getHasmo3ednotes()) {
            notes.setText(mo3eed.getMo3ednotes());
        } else {
            l6.setVisibility(View.GONE);
        }




        return convertView;
    }
}