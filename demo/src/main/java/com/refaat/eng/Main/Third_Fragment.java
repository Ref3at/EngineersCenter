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
public class Third_Fragment extends Fragment {
    Student mStudent;


    public static final String TAG = Third_Fragment.class.getSimpleName();
    ListView mlistView;
    ArrayAdapter<String> mSubjectsAdapter;

    TextView textViewSubjects;

    public Third_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            mStudent = arguments.getParcelable(Third_Fragment.TAG);
        }

        String[] data = {
                "s1",
                "S2",
                "S3",
                "S4",
                "S5",
                "S6"
        };

        //-------------------------------------------------------------------------------------------
        Resources res = getResources();

        if (mStudent.getYearPostion() == 0) {
            data = res.getStringArray(R.array.Y0);
        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 0) {
            data = res.getStringArray(R.array.Y10);

        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 1) {
            data = res.getStringArray(R.array.Y11);
        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 2) {
            data = res.getStringArray(R.array.Y12);
        } else if (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 3) {
            data = res.getStringArray(R.array.Y13);
        } else if (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 0) {
            data = res.getStringArray(R.array.Y20);

        } else if (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 1) {
            data = res.getStringArray(R.array.Y21);

        } else if (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 2) {
            data = res.getStringArray(R.array.Y22);

        } else if (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 3) {
            data = res.getStringArray(R.array.Y23);

        } else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 0) {
            data = res.getStringArray(R.array.Y30);

        } else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 1) {
            data = res.getStringArray(R.array.Y31);

        } else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2) {
            data = res.getStringArray(R.array.Y32);

        } else if (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 3) {
            data = res.getStringArray(R.array.Y33);

        } else if (mStudent.getYearPostion() == 4 && mStudent.getMajorPostion() == 0) {
            data = res.getStringArray(R.array.Y40);

        } else if (mStudent.getYearPostion() == 4 && mStudent.getMajorPostion() == 1) {
            data = res.getStringArray(R.array.Y41);

        } else if (mStudent.getYearPostion() == 4 && mStudent.getMajorPostion() == 2) {
            data = res.getStringArray(R.array.Y42);

        } else {
            data = res.getStringArray(R.array.Y43);

        }


        //-------------------------------------------------------------------------------------------


        List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));


        // Now that we have some dummy forecast data, create an ArrayAdapter.
        // The ArrayAdapter will take data from a source (like our dummy forecast) and
        // use it to populate the ListView it's attached to.
        mSubjectsAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        // R.layout.listview_textviewmajors, // The name of the layout ID.
                        R.layout.litstview_textviewsubjects, // The name of the layout ID.
                        R.id.list_item_subjects_textview, // The ID of the textview to populate.
                        weekForecast);

        View rootView = inflater.inflate(R.layout.layout_subjects, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        mlistView = (ListView) rootView.findViewById(R.id.listview_subjects);
        mlistView.setAdapter(mSubjectsAdapter);

        textViewSubjects = (TextView) rootView.findViewById(R.id.textview_subjects);


        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView textView = (TextView) view;
                String textt = (String) textView.getText();
                mStudent.setSubjectName(textt);
                mStudent.setSubjectsPosition(position);

                if ((mStudent.getYearPostion() == 0 && mStudent.getSubjectsPosition() == 0) ||
                        (mStudent.getYearPostion() == 0 && mStudent.getSubjectsPosition() == 1) ||
                        (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 0 && mStudent.getSubjectsPosition() == 0) |
                                (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 1 && mStudent.getSubjectsPosition() == 4) |
                                (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) |
                                (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 2) |
                                (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 0 && mStudent.getSubjectsPosition() == 3) |
                                (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) |
                                (mStudent.getYearPostion() == 2 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 1) |
                                (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 0 && mStudent.getSubjectsPosition() == 5) |
                                (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 1 && mStudent.getSubjectsPosition() == 2) |
                                (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) |
                                (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 1) |
                                (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 3) |
                                (mStudent.getYearPostion() == 3 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 5) |
                                (mStudent.getYearPostion() == 4 && mStudent.getMajorPostion() == 2 && mStudent.getSubjectsPosition() == 0) |
                                (mStudent.getYearPostion() == 1 && mStudent.getMajorPostion() == 3 && mStudent.getSubjectsPosition() == 0))

                {
                    List<String> oneitem = new ArrayList<String>();
                    oneitem.add(textt);
                    mSubjectsAdapter =
                            new ArrayAdapter<String>(
                                    getActivity(), // The current context (this activity)
                                    R.layout.litstview_textviewsubjects, // The name of the layout ID.
                                    R.id.list_item_subjects_textview, // The ID of the textview to populate.
                                    oneitem);
                    textViewSubjects.setVisibility(View.GONE);

                    mlistView.setAdapter(mSubjectsAdapter);


                    ((Callback3) getActivity()).onItemSelected3(mStudent);
                } else


                {

                    Intent i = new Intent(getActivity(), DetailActivity.class);
                    i.putExtra("subject", mStudent.getSubjectName());
                    i.putExtra("year",mStudent.getYear());
                    i.putExtra("major",mStudent.getMajor());
                    startActivity(i);


                }


            }
        });

        return rootView;
    }


    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callback3 {

        void onItemSelected3(Student s);

    }
}

