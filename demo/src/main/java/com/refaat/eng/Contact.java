package com.refaat.eng;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                Toast.makeText(this, "About page", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(Contact.this, About.class));

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void contanctclick(View view) {
        int x = view.getId();

        switch (x) {
            case R.id.callzizo:
                FireMissilesDialogFragment dialogFragment = new FireMissilesDialogFragment("Mohamed Zidan", "01092809659");
                dialogFragment.show(getSupportFragmentManager(), "TAG");
                break;
            case R.id.callshrif:
                FireMissilesDialogFragment dialogFragment2 = new FireMissilesDialogFragment("Sherif Mahmoud", "01092881520");
                dialogFragment2.show(getSupportFragmentManager(), "TAG");
                break;
            case R.id.callmansy:
                FireMissilesDialogFragment dialogFragment3 = new FireMissilesDialogFragment("Mohamed El Mansy", "01224304309");
                dialogFragment3.show(getSupportFragmentManager(), "TAG");
                break;
            case R.id.fbzizo:
                startActivity(getOpenFacebookIntent(getApplicationContext(), "100000337424585", "zizo32"));

                break;
            case R.id.fbshrief:
                startActivity(getOpenFacebookIntent(getApplicationContext(), "100000901673711", "100000901673711"));

                break;
            case R.id.fbmansy:
                startActivity(getOpenFacebookIntent(getApplicationContext(), "100002631233415", "elmansy.mohamed.9"));

                break;
            case R.id.zizogm:
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();

                break;
            case R.id.shriefgm:
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();

                break;
            case R.id.mansygm:
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();

                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    public static Intent getOpenFacebookIntent(Context context, String id, String username) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/" + id));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + username));
        }
    }

    public static class FireMissilesDialogFragment extends DialogFragment {

        String nm;
        String phone;

        public FireMissilesDialogFragment() {
        }

        public FireMissilesDialogFragment(String name, String phNum) {

            this.nm = name;
            this.phone = phNum;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Call " + nm + " ?")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    ActivityCompat#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for ActivityCompat#requestPermissions for more details.
                                return;
                            }
                            startActivity(intent);

                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog

                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
