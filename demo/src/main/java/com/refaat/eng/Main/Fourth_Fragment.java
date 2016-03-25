package com.refaat.eng.Main;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.refaat.eng.DetailActivity.DetailActivity;
import com.refaat.eng.R;
import com.refaat.eng.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ogaclejapan on 2/17/2016.
 */
public class Fourth_Fragment extends Fragment {
    Student mStudent = new Student();


    public static final String TAG = Fourth_Fragment.class.getSimpleName();

    ArrayAdapter<String> mBranchesAdapter;
    ListView mlistView;

    TextView textViewMajors;


    public Fourth_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            mStudent = arguments.getParcelable(Fourth_Fragment.TAG);
        }

        String[] data = {

                "الفرع الاول ",
                "الفرع التانى"
        };


        Resources res = getResources();

        if (mStudent.getYearPostion() == 0 && mStudent.getSubjectsPosition() == 0) {
            data = res.getStringArray(R.array.Y000);
        } else if (mStudent.getYearPostion() == 0 && mStudent.getSubjectsPosition() == 1) {
            data = res.getStringArray(R.array.Y001);

        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 0 && mStudent.getSubjectsPosition() == 0) {
            data = res.getStringArray(R.array.Y100);
        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) {
            data = res.getStringArray(R.array.Y120);
        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 2) {
            data = res.getStringArray(R.array.Y122);
        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 1 && mStudent.getSubjectsPosition() == 4) {
            data = res.getStringArray(R.array.Y114);
        } else if (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) {
            data = res.getStringArray(R.array.Y220);
        } else if (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 1) {
            data = res.getStringArray(R.array.Y221);
        } else if (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 0 && mStudent.getSubjectsPosition() == 3) {
            data = res.getStringArray(R.array.Y203);
        }else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 0 && mStudent.getSubjectsPosition() == 5) {
            data = res.getStringArray(R.array.Y305);
        }else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) {
            data = res.getStringArray(R.array.Y320);
        } else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 1) {
            data = res.getStringArray(R.array.Y321);
        } else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 5) {
            data = res.getStringArray(R.array.Y325);
        } else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 1 && mStudent.getSubjectsPosition() == 2) {
            data = res.getStringArray(R.array.Y312);
        } else if (mStudent.getYearPostion() == 4 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) {
            data = res.getStringArray(R.array.Y420);
        } else {
            data = res.getStringArray(R.array.Y999);

        }


        //-------------------------------------------------------------------------------------------


        List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));


        // Now that we have some dummy forecast data, create an ArrayAdapter.
        // The ArrayAdapter will take data from a source (like our dummy forecast) and
        // use it to populate the ListView it's attached to.
        mBranchesAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.listview_textviewbranches, // The name of the layout ID.
                        R.id.list_item_branches_textview, // The ID of the textview to populate.
                        weekForecast);

        View rootView = inflater.inflate(R.layout.layout_branches, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        mlistView = (ListView) rootView.findViewById(R.id.listview_majors);
        mlistView.setAdapter(mBranchesAdapter);
        textViewMajors = (TextView) rootView.findViewById(R.id.textview_branches);

        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textView = (TextView) view;
                String textt = (String) textView.getText();
                mStudent.setBranshName(textt);
                mStudent.setBranshPostion(position);

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("subject", mStudent.getSubjectName() + " - " + mStudent.getBranshName());
                i.putExtra("year",mStudent.getYear());
                i.putExtra("major",mStudent.getMajor());
                startActivity(i);

            }
        });

        return rootView;
    }


}
