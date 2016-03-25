package com.refaat.eng;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.ogaclejapan.arclayout.ArcLayout;
import com.refaat.eng.Main.Main_Activity;
import com.refaat.eng.Main.Third_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int currentstate;
    View fab;

    View menuLayoutYear;
    View menuLayoutMajor;

    Student mStudent = new Student();

    ArcLayout arcLayoutYear;
    ArcLayout arcLayoutMajor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.layout_main);

      TextView textView = (TextView) findViewById(R.id.texx);
      Animation a = AnimationUtils.loadAnimation(this,R.anim.enter_anim);

      textView.setAnimation(a);


//      ActionBar bar = getSupportActionBar();
      //   bar.setTitle(demo.titleResId);
    //  bar.setDisplayHomeAsUpEnabled(true);

      fab = findViewById(R.id.fab);


      menuLayoutYear = findViewById(R.id.menu_year);
      menuLayoutMajor = findViewById(R.id.menu_major);


      arcLayoutYear = (ArcLayout) findViewById(R.id.arc_year);
      arcLayoutMajor = (ArcLayout) findViewById(R.id.arc_major);

      for (int i = 0, size = arcLayoutYear.getChildCount(); i < size; i++) {
        arcLayoutYear.getChildAt(i).setOnClickListener(this);
      }
      for (int i = 0, size = arcLayoutMajor.getChildCount(); i < size; i++) {
        arcLayoutMajor.getChildAt(i).setOnClickListener(this);
      }



      fab.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

      if (v.getId() == R.id.fab) {
        onFabClick(v);
        return;
      }

      if (v instanceof Button && currentstate == 0) {
        if (((Button) v).getText().toString().equals("إعدادى")) {
          mStudent.setYearPostion(0);
          mStudent.setYear(((Button) v).getText().toString());
          Intent i = new Intent(MainActivity.this, Main_Activity.class);
          Bundle b = new Bundle();
          b.putParcelable(Third_Fragment.TAG, mStudent);
          i.putExtras(b);
          startActivity(i);
        } else if (((Button) v).getText().toString().equals("أولى")) {
          showToast((Button) v);
          mStudent.setYearPostion(1);
          mStudent.setYear(((Button) v).getText().toString());
        } else if (((Button) v).getText().toString().equals("تانيه")) {
          showToast((Button) v);
          mStudent.setYearPostion(2);
          mStudent.setYear(((Button) v).getText().toString());
        } else if (((Button) v).getText().toString().equals("تالته")) {
          showToast((Button) v);
          mStudent.setYearPostion(3);
          mStudent.setYear(((Button) v).getText().toString());
        } else if (((Button) v).getText().toString().equals("رابعه")) {
          mStudent.setYearPostion(4);
          mStudent.setYear(((Button) v).getText().toString());
          showToast((Button) v);

        }


      } else if (v instanceof Button && currentstate == 1) {


        if (((Button) v).getText().toString().equals("كهربا")) {
          mStudent.setMajorPostion(2);
          mStudent.setMajor(((Button) v).getText().toString());
        } else if (((Button) v).getText().toString().equals("اتصالات")) {
          mStudent.setMajorPostion(0);
          mStudent.setMajor(((Button) v).getText().toString());
        } else if (((Button) v).getText().toString().equals("مدنى")) {
          mStudent.setMajorPostion(3);
          mStudent.setMajor(((Button) v).getText().toString());
        } else if (((Button) v).getText().toString().equals("ميكانيكا")) {
          mStudent.setMajorPostion(1);
          mStudent.setMajor(((Button) v).getText().toString());
        }

        showToast2((Button) v);
      }
    }

    private void showToast(Button btn) {

      hideMenuYear();

      final Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
        @Override
        public void run() {
          showMenuMajor();
          currentstate = 1;
        }
      }, 500);

    }



    private void showToast2(Button btn) {

      // hideMenuMajor();


      final Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
        @Override
        public void run() {
          Intent i = new Intent(MainActivity.this, Main_Activity.class);
          Bundle b = new Bundle();
          b.putParcelable(Third_Fragment.TAG, mStudent);
          i.putExtras(b);
          startActivity(i);
        }
      }, 500);

    }


    private void onFabClick(View v) {
      /*  if (v.isSelected()) {
            hideMenuYear();
        } else {
            showMenuYear();
        }
        v.setSelected(!v.isSelected()); */
      if (currentstate == 0) {
        showMenuYear();

      }else if (currentstate == 1 ) {
        showMenuMajor();
      }
    }


    @SuppressWarnings("NewApi")
    private void showMenuYear() {
      menuLayoutYear.setVisibility(View.VISIBLE);

      List<Animator> animList = new ArrayList<>();

      for (int i = 0, len = arcLayoutYear.getChildCount(); i < len; i++) {

        animList.add(createShowItemAnimator(arcLayoutYear.getChildAt(i)));
      }

      AnimatorSet animSet = new AnimatorSet();
      animSet.setDuration(400);
      animSet.setInterpolator(new OvershootInterpolator());
      animSet.playTogether(animList);
      animSet.start();
    }


    @SuppressWarnings("NewApi")
    private void hideMenuYear() {

      List<Animator> animList = new ArrayList<>();

      for (int i = arcLayoutYear.getChildCount() - 1; i >= 0; i--) {
        animList.add(createHideItemAnimator(arcLayoutYear.getChildAt(i)));
      }

      AnimatorSet animSet = new AnimatorSet();
      animSet.setDuration(400);
      animSet.setInterpolator(new AnticipateInterpolator());
      animSet.playTogether(animList);
      animSet.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          super.onAnimationEnd(animation);
          menuLayoutYear.setVisibility(View.INVISIBLE);
        }
      });
      animSet.start();

    }



    @SuppressWarnings("NewApi")
    private void showMenuMajor() {
      menuLayoutMajor.setVisibility(View.VISIBLE);

      List<Animator> animList = new ArrayList<>();

      for (int i = 0, len = arcLayoutMajor.getChildCount(); i < len; i++) {
        animList.add(createShowItemAnimator(arcLayoutMajor.getChildAt(i)));
      }

      AnimatorSet animSet = new AnimatorSet();
      animSet.setDuration(400);
      animSet.setInterpolator(new OvershootInterpolator());
      animSet.playTogether(animList);
      animSet.start();
    }



    @SuppressWarnings("NewApi")
    private void hideMenuMajor() {

      List<Animator> animList = new ArrayList<>();

      for (int i = arcLayoutMajor.getChildCount() - 1; i >= 0; i--) {
        animList.add(createHideItemAnimator(arcLayoutMajor.getChildAt(i)));
      }

      AnimatorSet animSet = new AnimatorSet();
      animSet.setDuration(400);
      animSet.setInterpolator(new AnticipateInterpolator());
      animSet.playTogether(animList);
      animSet.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          super.onAnimationEnd(animation);
          menuLayoutMajor.setVisibility(View.INVISIBLE);
        }
      });
      animSet.start();

    }


    private Animator createShowItemAnimator(View item) {

      float dx = fab.getX() - item.getX();
      float dy = fab.getY() - item.getY();

      item.setRotation(0f);
      item.setTranslationX(dx);
      item.setTranslationY(dy);

      Animator anim = ObjectAnimator.ofPropertyValuesHolder(
              item,
              AnimatorUtils.rotation(0f, 720f),
              AnimatorUtils.translationX(dx, 0f),
              AnimatorUtils.translationY(dy, 0f)
      );

      return anim;
    }

    private Animator createHideItemAnimator(final View item) {
      float dx = fab.getX() - item.getX();
      float dy = fab.getY() - item.getY();

      Animator anim = ObjectAnimator.ofPropertyValuesHolder(
              item,
              AnimatorUtils.rotation(720f, 0f),
              AnimatorUtils.translationX(0f, dx),
              AnimatorUtils.translationY(0f, dy)
      );

      anim.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          super.onAnimationEnd(animation);
          item.setTranslationX(0f);
          item.setTranslationY(0f);
        }
      });

      return anim;
    }

    @Override
    public void onBackPressed() {

      if (currentstate == 1) {

        hideMenuMajor();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
          @Override
          public void run() {
            showMenuYear();
            currentstate = 0;
          }
        }, 500);
      } else {
        super.onBackPressed();
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
      Intent intent = new Intent(MainActivity.this, Contact.class);
      startActivity(intent);

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
           // startActivity(new Intent(MainActivity.this,About.class));
          return true;
        default:
          return super.onOptionsItemSelected(item);
      }
    }


  }