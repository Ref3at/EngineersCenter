package com.refaat.eng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Test_GCM extends AppCompatActivity {

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private final String LOG_TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__gcm);

        Toast.makeText(this,"start",Toast.LENGTH_SHORT).show();

        if (!checkPlayServices()) {
            // This is where we could either prompt a user that they should install
            // the latest version of Google Play Services, or add an error snackbar
            // that some features won't be available.
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"gcm: "+checkPlayServices(),Toast.LENGTH_SHORT).show();

    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
                Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
            } else {
                Log.i(LOG_TAG, "This device is not supported.");
                Toast.makeText(this,"faild",Toast.LENGTH_SHORT).show();

                finish();
            }
            return false;
        }
        return true;
    }



}
