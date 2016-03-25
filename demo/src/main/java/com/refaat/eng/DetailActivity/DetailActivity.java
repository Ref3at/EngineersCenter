package com.refaat.eng.DetailActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.refaat.eng.R;

public class DetailActivity extends AppCompatActivity implements Preview_fragment.PrevInterface, EditMo3ed_Fragment.EditInterface2 {
    EditMo3ed_Fragment editMo3edFragment = new EditMo3ed_Fragment();
    Preview_fragment previewFragment = new Preview_fragment();
    String mSubject;
    String mYear;
    String mMajor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Firebase.setAndroidContext(this);
if (this.getIntent() !=null) {
    Intent i = this.getIntent();
    mSubject = i.getExtras().getString("subject");
    mYear = i.getExtras().getString("year");
    mMajor = i.getExtras().getString("major");

}

        if (savedInstanceState == null) {

            Bundle arguments = new Bundle();
            arguments.putString("subject",mSubject);
            arguments.putString("year",mYear);
            arguments.putString("major",mMajor);

            if (!previewFragment.isAdded()) {
                previewFragment.setArguments(arguments);
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, previewFragment, Preview_fragment.TAG)
                    .commit();
        }
    }

    @Override
    public void onEditSelected() {

        getSupportFragmentManager().beginTransaction()
                .remove(previewFragment)
                .commit();
        editMo3edFragment = new EditMo3ed_Fragment();
        Bundle arguments = new Bundle();
        arguments.putString("subject", mSubject);
        arguments.putString("year",mYear);
        arguments.putString("major",mMajor);
        if (!editMo3edFragment.isAdded()) {
            editMo3edFragment.setArguments(arguments);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, editMo3edFragment)
                .commit();

    }

    @Override
    public void onPrevSelected2() {
        getSupportFragmentManager().beginTransaction()
                .remove(editMo3edFragment)
                .commit();
        previewFragment = new Preview_fragment();
        Bundle arguments = new Bundle();
        arguments.putString("subject",mSubject);
        arguments.putString("year",mYear);
        arguments.putString("major",mMajor);
        if (!previewFragment.isAdded()) {
            previewFragment.setArguments(arguments);
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, previewFragment)
                .commit();
    }
}

