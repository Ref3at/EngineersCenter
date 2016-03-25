package com.refaat.eng.Main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.refaat.eng.About;
import com.refaat.eng.Contact;
import com.refaat.eng.R;
import com.refaat.eng.Student;


public class Main_Activity extends AppCompatActivity implements  Third_Fragment.Callback3 {


    int active_fragment;

    boolean in_third_wE3dady;

    Student mStudent;



    Third_Fragment thirdFragment = new Third_Fragment();
    Fourth_Fragment fourthFragment = new Fourth_Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainn);

        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            mStudent = b.getParcelable(Third_Fragment.TAG);

            Bundle arguments = new Bundle();
            arguments.putParcelable(Third_Fragment.TAG, mStudent);
             thirdFragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.subjects_container, thirdFragment)
                    .commit();

            active_fragment = 3;

        }


    }

    @Override
    public void onItemSelected3(Student s) {

        mStudent = s;

        Bundle arguments = new Bundle();
        arguments.putParcelable(Fourth_Fragment.TAG, s);

        if (!fourthFragment.isAdded()) {
            fourthFragment.setArguments(arguments);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.branches_container, fourthFragment)
                .commit();
        active_fragment = 4;

    }

    @Override
    public void onBackPressed() {
         if (active_fragment == 4)

        {
            getSupportFragmentManager().beginTransaction()
                    .remove(fourthFragment)
                    .commit();
            thirdFragment = new Third_Fragment();

            Bundle arguments = new Bundle();
            arguments.putParcelable(Third_Fragment.TAG, mStudent);

            if (!thirdFragment.isAdded()) {
                thirdFragment.setArguments(arguments);
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.subjects_container, thirdFragment)
                    .commit();
            active_fragment = 3;
        } else {

            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.info:
                Toast.makeText(this, "Engineers Cetner", Toast.LENGTH_SHORT).show();
            //    startActivity(new Intent(Main_Activity.this, About.class));

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void facebookintent(View view) {

       startActivity(getOpenFacebookIntent(getApplicationContext()));
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/300687426612432"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Engineerscenter"));
        }
    }

    public void opencontactpage(View view) {
        Intent intent = new Intent(Main_Activity.this, Contact.class);
        startActivity(intent);

    }
}
