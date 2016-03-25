package com.refaat.eng.DetailActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.refaat.eng.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogaclejapan on 2/17/2016.
 */
public class Preview_fragment extends Fragment {

    public static final String TAG = Preview_fragment.class.getSimpleName();
    Firebase mfirebase;
    TextView prevTextView;
    ListView mlistView;
    Mo3eden_Adapter mo3eden_adapter;

    public Preview_fragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
                inflater.inflate(R.menu.about,menu);
          //   inflater.inflate(R.menu.prevpage, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        switch (item_id) {
         /*   case R.id.action_edit:

                if (isNetworkAvailable()) {
                    ((PrevInterface) getActivity()).onEditSelected();
                } else
                    Toast.makeText(getActivity(), "You Must Have Internet Connection To Do Edit!", Toast.LENGTH_SHORT).show();

               return true;*/

            case R.id.info:
                Toast.makeText(getActivity(), "Engineers Cetner", Toast.LENGTH_SHORT).show();
                // startActivity(new Intent(MainActivity.this,About.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    ProgressDialog pG;
    String mSubject;
    String mYear;
    String mMajor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (!isNetworkAvailable()) {
            Toast.makeText(getActivity(), "You Don't Have Internet Connection To Show Data!, Connect First and Try Again", Toast.LENGTH_LONG).show();
        }


        Bundle arguments = getArguments();
        if (arguments != null) {
            mSubject = arguments.getString("subject");
            mYear = arguments.getString("year");
            mMajor = arguments.getString("major");
        }

        Firebase ref = new Firebase("https://engcenter.firebaseio.com/new/"+mYear+"/"+mMajor+"/"+mSubject);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {


                ay7aga(snapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });


        View rootView = inflater.inflate(R.layout.mo3eed_fragment, container, false);
        mlistView = (ListView) rootView.findViewById(R.id.listview_mo3eeds);

        View emptyview = rootView.findViewById(R.id.listview_forecast_empty);

        if (isNetworkAvailable()) {

            pG = new ProgressDialog(getContext());
            pG.setCancelable(true);
            pG.setMessage("Retrieving data...");
            pG.setTitle("Please wait");
            pG.setIndeterminate(true);
            pG.show();
        } else {
            mlistView.setEmptyView(emptyview);
        }
        TextView textViewsunmm = (TextView) rootView.findViewById(R.id.subnm);
        textViewsunmm.setText(mSubject);


        mlistView.setAdapter(mo3eden_adapter);

        return rootView;

    }

    public void ay7aga(DataSnapshot snapshot) {
        List<Mo3eed> blogPosts = new ArrayList<Mo3eed>() {
        };

        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
            Mo3eed post = postSnapshot.getValue(Mo3eed.class);
            blogPosts.add(post);
        }
        if (getActivity() != null) {
            mo3eden_adapter = new Mo3eden_Adapter(getActivity(), blogPosts);
            mlistView.setAdapter(mo3eden_adapter);
            if(pG != null && pG.isShowing()){
                pG.dismiss ( ) ;
            }        }
    }

    public boolean isNetworkAvailable()

    {
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public void updateemptyView() {
        if (mo3eden_adapter.getCount() == 0) {
            TextView tv = (TextView) getView().findViewById(R.id.listview_forecast_empty);
            if (null != tv) {
                int message = R.string.empty_list;
                if (!isNetworkAvailable()) {
                    message = R.string.empty_list2;
                }
                tv.setText(message);
            }
        }
    }






    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface PrevInterface {
        void onEditSelected();
    }
}
