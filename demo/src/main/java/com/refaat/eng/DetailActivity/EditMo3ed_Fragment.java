package com.refaat.eng.DetailActivity;

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
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
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
 * Created by ogaclejapan on 2/18/2016.
 */
public class EditMo3ed_Fragment extends Fragment {
    public static final String TAG = EditMo3ed_Fragment.class.getSimpleName();
    LinearLayout mContainr;
    Button mAdd, prevwbtn;
    List<Mo3eed> finalMo3eedslist = new ArrayList<Mo3eed>();
    Firebase firebase;

    public EditMo3ed_Fragment() {
    }

String mSubject;
String mYear;
String mMajor;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Bundle arguments = getArguments();
        if (arguments != null) {
            mSubject = arguments.getString("subject");
            mYear = arguments.getString("year");
            mMajor = arguments.getString("major");


        }
        firebase = new Firebase("https://engcenter.firebaseio.com/new/"+mYear+"/"+mMajor+"/"+mSubject);


        // Get a reference to our posts
        // Attach an listener to read the data at our posts reference
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                fetshfromSnapshot(snapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        View rootView = inflater.inflate(R.layout.activity_for_test2, container, false);
        mContainr = (LinearLayout) rootView.findViewById(R.id.parentView2);

        return rootView;
    }

    public void fetshfromSnapshot(DataSnapshot snapshot) {
        mContainr.removeAllViews();

        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
            Mo3eed post = postSnapshot.getValue(Mo3eed.class);
            inflateRowbyDB(post);
        }

    }

    public void inflateRowbyDB(final Mo3eed m) {

        if (getActivity() != null) {
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final View rootview = inflater.inflate(R.layout.editcardbydb, null);

            final Switch t1, t2, t3, t4, t5, t6;

            final EditText edtName, edtNotes;
            edtName = (EditText) rootview.findViewById(R.id.editname);
            edtNotes = (EditText) rootview.findViewById(R.id.edidtext_note);

            final TextView textname, textnote, N1, N2, N3, N4, N5;


            textname = (TextView) rootview.findViewById(R.id.textname);
            textname.setText(m.getMo3eedname());

            textnote = (TextView) rootview.findViewById(R.id.text_note);
            textnote.setText(m.getMo3ednotes());

            N1 = (TextView) rootview.findViewById(R.id.int_shr7);
            N1.setText(m.getShr7numb());
            N2 = (TextView) rootview.findViewById(R.id.int_morg);
            N2.setText(m.getMorag3anum());
            N3 = (TextView) rootview.findViewById(R.id.int_sec);
            N3.setText(m.getSectionsnum());
            N4 = (TextView) rootview.findViewById(R.id.int_sheet);
            N4.setText(m.getSheetnumb());
            N5 = (TextView) rootview.findViewById(R.id.int_emt7an);
            N5.setText(m.getEmt7anatnum());

            final Button don, edit;

            don = (Button) rootview.findViewById(R.id.done_btn);
            edit = (Button) rootview.findViewById(R.id.edit_btn);

            final Button p1, p2, p3, p4, p5, m1, m2, m3, m4, m5;


            final LinearLayout l1, l2, l3, l4, l5, l6;


            final ImageButton del_imbtn = (ImageButton) rootview.findViewById(R.id.delete);


            p1 = (Button) rootview.findViewById(R.id.plus1);
            p2 = (Button) rootview.findViewById(R.id.plus2);
            p3 = (Button) rootview.findViewById(R.id.plus3);
            p4 = (Button) rootview.findViewById(R.id.plus4);
            p5 = (Button) rootview.findViewById(R.id.plus5);

            m1 = (Button) rootview.findViewById(R.id.mins1);
            m2 = (Button) rootview.findViewById(R.id.mins2);
            m3 = (Button) rootview.findViewById(R.id.mins3);
            m4 = (Button) rootview.findViewById(R.id.mins4);
            m5 = (Button) rootview.findViewById(R.id.mins5);


            l1 = (LinearLayout) rootview.findViewById(R.id.l1);
            l2 = (LinearLayout) rootview.findViewById(R.id.l2);
            l3 = (LinearLayout) rootview.findViewById(R.id.l3);
            l4 = (LinearLayout) rootview.findViewById(R.id.l4);
            l5 = (LinearLayout) rootview.findViewById(R.id.l5);
            l6 = (LinearLayout) rootview.findViewById(R.id.l6);


            t1 = (Switch) rootview.findViewById(R.id.tog1);
            t2 = (Switch) rootview.findViewById(R.id.tog2);
            t3 = (Switch) rootview.findViewById(R.id.tog3);
            t4 = (Switch) rootview.findViewById(R.id.tog4);
            t5 = (Switch) rootview.findViewById(R.id.tog5);
            t6 = (Switch) rootview.findViewById(R.id.tog6);


            if (m.getHasshr7numb()) {
                t1.setChecked(true);
            } else {
                t1.setChecked(false);
                l1.setVisibility(View.GONE);
            }

            if (m.getHasmorag3anum()) {
                t2.setChecked(true);
            } else {
                t2.setChecked(false);
                l2.setVisibility(View.GONE);
            }
            if (m.getHassectionsnum()) {
                t3.setChecked(true);
            } else {
                t3.setChecked(false);
                l3.setVisibility(View.GONE);
            }

            if (m.getHassheetnumb()) {
                t4.setChecked(true);
            } else {
                t4.setChecked(false);
                l4.setVisibility(View.GONE);
            }
            if (m.getHasemt7anatnum()) {
                t5.setChecked(true);
            } else {
                t5.setChecked(false);
                l5.setVisibility(View.GONE);
            }

            if (m.getHasmo3ednotes()) {
                t6.setChecked(true);
            } else {
                t6.setChecked(false);
                l6.setVisibility(View.GONE);
            }

            mContainr.addView(rootview, 0);

            del_imbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContainr.removeView(rootview);
                }
            });


            p1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = Integer.parseInt(N1.getText().toString());
                    x = x + 1;
                    N1.setText(x + "");

                }
            });

            p2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = Integer.parseInt(N2.getText().toString());
                    x = x + 1;
                    N2.setText(x + "");

                }
            });

            p3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = Integer.parseInt(N3.getText().toString());
                    x = x + 1;
                    N3.setText(x + "");

                }
            });

            p4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = Integer.parseInt(N4.getText().toString());
                    x = x + 1;
                    N4.setText(x + "");

                }
            });

            p5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x = Integer.parseInt(N5.getText().toString());
                    x = x + 1;
                    N5.setText(x + "");

                }
            });

            m1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int x = Integer.parseInt(N1.getText().toString());
                    if (x == 0) {
                        return;
                    }
                    x = x - 1;
                    N1.setText(x + "");

                }
            });
            m2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int x = Integer.parseInt(N2.getText().toString());
                    if (x == 0) {
                        return;
                    }
                    x = x - 1;
                    N2.setText(x + "");

                }
            });
            m3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int x = Integer.parseInt(N3.getText().toString());
                    if (x == 0) {
                        return;
                    }
                    x = x - 1;
                    N3.setText(x + "");

                }
            });
            m4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int x = Integer.parseInt(N4.getText().toString());
                    if (x == 0) {
                        return;
                    }
                    x = x - 1;
                    N4.setText(x + "");

                }
            });
            m5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int x = Integer.parseInt(N5.getText().toString());
                    if (x == 0) {
                        return;
                    }
                    x = x - 1;
                    N5.setText(x + "");

                }
            });


            t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // The toggle is enabled
                        Toast.makeText(getActivity(), "enable", Toast.LENGTH_SHORT).show();
                        l1.setAlpha(1.0f);
                        m.setHasshr7numb(true);


                    } else {
                        // The toggle is disabled
                        Toast.makeText(getActivity(), "disabled", Toast.LENGTH_SHORT).show();
                        l1.setAlpha(0.3f);
                        m.setHasshr7numb(false);


                    }
                }
            });

            t2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // The toggle is enabled
                        l2.setAlpha(1.0f);
                        m.setHasmorag3anum(true);


                    } else {
                        // The toggle is disabled
                        l2.setAlpha(0.3f);
                        m.setHasmorag3anum(false);


                    }
                }
            });

            t3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // The toggle is enabled
                        l3.setAlpha(1.0f);
                        m.setHassectionsnum(true);


                    } else {
                        // The toggle is disabled
                        l3.setAlpha(0.3f);
                        m.setHassectionsnum(false);


                    }
                }
            });

            t4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // The toggle is enabled
                        l4.setAlpha(1.0f);
                        m.setHassheetnumb(true);


                    } else {
                        // The toggle is disabled
                        l4.setAlpha(0.3f);
                        m.setHassheetnumb(false);


                    }
                }
            });

            t5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // The toggle is enabled
                        l5.setAlpha(1.0f);
                        m.setHasemt7anatnum(true);

                    } else {
                        // The toggle is disabled
                        l5.setAlpha(0.3f);
                        m.setHasemt7anatnum(false);


                    }
                }
            });

            t6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // The toggle is enabled
                        l6.setAlpha(1.0f);
                        m.setHasmo3ednotes(true);


                    } else {
                        // The toggle is disabled
                        l6.setAlpha(0.3f);
                        m.setHasmo3ednotes(false);


                    }
                }
            });

            don.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    p1.setVisibility(View.INVISIBLE);
                    p2.setVisibility(View.INVISIBLE);
                    p3.setVisibility(View.INVISIBLE);
                    p4.setVisibility(View.INVISIBLE);
                    p5.setVisibility(View.INVISIBLE);
                    m1.setVisibility(View.INVISIBLE);
                    m2.setVisibility(View.INVISIBLE);
                    m3.setVisibility(View.INVISIBLE);
                    m4.setVisibility(View.INVISIBLE);
                    m5.setVisibility(View.INVISIBLE);

                    t1.setVisibility(View.INVISIBLE);
                    t2.setVisibility(View.INVISIBLE);
                    t3.setVisibility(View.INVISIBLE);
                    t4.setVisibility(View.INVISIBLE);
                    t5.setVisibility(View.INVISIBLE);
                    t6.setVisibility(View.INVISIBLE);

                    del_imbtn.setVisibility(View.INVISIBLE);
                    don.setVisibility(View.GONE);
                    edit.setVisibility(View.VISIBLE);

                    textname.setText(edtName.getText());
                    edtName.setVisibility(View.GONE);
                    textname.setVisibility(View.VISIBLE);

                    textnote.setText(edtNotes.getText());
                    edtNotes.setVisibility(View.GONE);
                    textnote.setVisibility(View.VISIBLE);
                    if (edtNotes.getText().length() == 0) {
                        t6.setChecked(false);
                    }

                    if (!t1.isChecked()) {
                        l1.setVisibility(View.GONE);
                        m.setHasshr7numb(false);
                    }
                    if (!t2.isChecked()) {
                        l2.setVisibility(View.GONE);
                        m.setHasmorag3anum(false);
                    }
                    if (!t3.isChecked()) {
                        l3.setVisibility(View.GONE);
                        m.setHassectionsnum(false);
                    }
                    if (!t4.isChecked()) {
                        l4.setVisibility(View.GONE);
                        m.setHassheetnumb(false);
                    }
                    if (!t5.isChecked()) {
                        l5.setVisibility(View.GONE);
                        m.setHasemt7anatnum(false);

                    }
                    if (!t6.isChecked()) {
                        l6.setVisibility(View.GONE);
                        m.setHasmo3ednotes(false);
                    }


                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    p1.setVisibility(View.VISIBLE);
                    p2.setVisibility(View.VISIBLE);
                    p3.setVisibility(View.VISIBLE);
                    p4.setVisibility(View.VISIBLE);
                    p5.setVisibility(View.VISIBLE);
                    m1.setVisibility(View.VISIBLE);
                    m2.setVisibility(View.VISIBLE);
                    m3.setVisibility(View.VISIBLE);
                    m4.setVisibility(View.VISIBLE);
                    m5.setVisibility(View.VISIBLE);

                    t1.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.VISIBLE);
                    t3.setVisibility(View.VISIBLE);
                    t4.setVisibility(View.VISIBLE);
                    t5.setVisibility(View.VISIBLE);
                    t6.setVisibility(View.VISIBLE);

                    del_imbtn.setVisibility(View.VISIBLE);
                    don.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);

                    edtName.setText(textname.getText());
                    textname.setVisibility(View.GONE);
                    edtName.setVisibility(View.VISIBLE);

                    edtNotes.setText(textnote.getText());
                    textnote.setVisibility(View.GONE);
                    edtNotes.setVisibility(View.VISIBLE);

                    if (l1.getVisibility() == View.GONE) {
                        l1.setAlpha(0.3f);
                        l1.setVisibility(View.VISIBLE);
                    }
                    if (l2.getVisibility() == View.GONE) {
                        l2.setAlpha(0.3f);
                        l2.setVisibility(View.VISIBLE);
                    }
                    if (l3.getVisibility() == View.GONE) {
                        l3.setAlpha(0.3f);
                        l3.setVisibility(View.VISIBLE);
                    }
                    if (l4.getVisibility() == View.GONE) {
                        l4.setAlpha(0.3f);
                        l4.setVisibility(View.VISIBLE);
                    }
                    if (l5.getVisibility() == View.GONE) {
                        l5.setAlpha(0.3f);
                        l5.setVisibility(View.VISIBLE);
                    }
                    if (l6.getVisibility() == View.GONE) {
                        l6.setAlpha(0.3f);
                        l6.setVisibility(View.VISIBLE);
                    }

                }
            });
        }
    }

    public void inflateRowbyAdd() {

        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rootview = inflater.inflate(R.layout.editcardbyadd, null);

        final Switch t1, t2, t3, t4, t5, t6;


        final EditText edtName, edtNotes;
        edtName = (EditText) rootview.findViewById(R.id.editname);
        edtNotes = (EditText) rootview.findViewById(R.id.edidtext_note);

        final TextView textname, textnote, N1, N2, N3, N4, N5;


        textname = (TextView) rootview.findViewById(R.id.textname);
        textnote = (TextView) rootview.findViewById(R.id.text_note);

        N1 = (TextView) rootview.findViewById(R.id.int_shr7);
        N2 = (TextView) rootview.findViewById(R.id.int_morg);
        N3 = (TextView) rootview.findViewById(R.id.int_sec);
        N4 = (TextView) rootview.findViewById(R.id.int_sheet);
        N5 = (TextView) rootview.findViewById(R.id.int_emt7an);

        final Button don, edit;

        don = (Button) rootview.findViewById(R.id.done_btn);
        edit = (Button) rootview.findViewById(R.id.edit_btn);
        final ImageButton del_imbtn = (ImageButton) rootview.findViewById(R.id.delete);


        final Button p1, p2, p3, p4, p5, m1, m2, m3, m4, m5;


        final LinearLayout l1, l2, l3, l4, l5, l6;


        p1 = (Button) rootview.findViewById(R.id.plus1);
        p2 = (Button) rootview.findViewById(R.id.plus2);
        p3 = (Button) rootview.findViewById(R.id.plus3);
        p4 = (Button) rootview.findViewById(R.id.plus4);
        p5 = (Button) rootview.findViewById(R.id.plus5);

        m1 = (Button) rootview.findViewById(R.id.mins1);
        m2 = (Button) rootview.findViewById(R.id.mins2);
        m3 = (Button) rootview.findViewById(R.id.mins3);
        m4 = (Button) rootview.findViewById(R.id.mins4);
        m5 = (Button) rootview.findViewById(R.id.mins5);


        l1 = (LinearLayout) rootview.findViewById(R.id.l1);
        l1.setAlpha(0.5f);
        l2 = (LinearLayout) rootview.findViewById(R.id.l2);
        l2.setAlpha(0.5f);
        l3 = (LinearLayout) rootview.findViewById(R.id.l3);
        l3.setAlpha(0.5f);
        l4 = (LinearLayout) rootview.findViewById(R.id.l4);
        l4.setAlpha(0.5f);
        l5 = (LinearLayout) rootview.findViewById(R.id.l5);
        l5.setAlpha(0.5f);
        l6 = (LinearLayout) rootview.findViewById(R.id.l6);
        l6.setAlpha(0.5f);


        t1 = (Switch) rootview.findViewById(R.id.tog1);
        t2 = (Switch) rootview.findViewById(R.id.tog2);
        t3 = (Switch) rootview.findViewById(R.id.tog3);
        t4 = (Switch) rootview.findViewById(R.id.tog4);
        t5 = (Switch) rootview.findViewById(R.id.tog5);
        t6 = (Switch) rootview.findViewById(R.id.tog6);


        mContainr.addView(rootview, 0);

        del_imbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContainr.removeView(rootview);
            }
        });


        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(N1.getText().toString());
                x = x + 1;
                N1.setText(x + "");

            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(N2.getText().toString());
                x = x + 1;
                N2.setText(x + "");

            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(N3.getText().toString());
                x = x + 1;
                N3.setText(x + "");

            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(N4.getText().toString());
                x = x + 1;
                N4.setText(x + "");

            }
        });

        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(N5.getText().toString());
                x = x + 1;
                N5.setText(x + "");

            }
        });

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = Integer.parseInt(N1.getText().toString());
                if (x == 0) {
                    return;
                }
                x = x - 1;
                N1.setText(x + "");

            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = Integer.parseInt(N2.getText().toString());
                if (x == 0) {
                    return;
                }
                x = x - 1;
                N2.setText(x + "");

            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = Integer.parseInt(N3.getText().toString());
                if (x == 0) {
                    return;
                }
                x = x - 1;
                N3.setText(x + "");

            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = Integer.parseInt(N4.getText().toString());
                if (x == 0) {
                    return;
                }
                x = x - 1;
                N4.setText(x + "");

            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = Integer.parseInt(N5.getText().toString());
                if (x == 0) {
                    return;
                }
                x = x - 1;
                N5.setText(x + "");

            }
        });


        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast.makeText(getActivity(), "enable", Toast.LENGTH_SHORT).show();
                    l1.setAlpha(1.0f);


                } else {
                    // The toggle is disabled
                    Toast.makeText(getActivity(), "disabled", Toast.LENGTH_SHORT).show();
                    l1.setAlpha(0.3f);


                }
            }
        });

        t2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    l2.setAlpha(1.0f);

                } else {
                    // The toggle is disabled
                    l2.setAlpha(0.3f);

                }
            }
        });

        t3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    l3.setAlpha(1.0f);

                } else {
                    // The toggle is disabled
                    l3.setAlpha(0.3f);

                }
            }
        });

        t4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    l4.setAlpha(1.0f);

                } else {
                    // The toggle is disabled
                    l4.setAlpha(0.3f);

                }
            }
        });

        t5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    l5.setAlpha(1.0f);

                } else {
                    // The toggle is disabled
                    l5.setAlpha(0.3f);

                }
            }
        });

        t6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    l6.setAlpha(1.0f);

                } else {
                    // The toggle is disabled
                    l6.setAlpha(0.3f);

                }
            }
        });

        don.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setVisibility(View.INVISIBLE);
                p2.setVisibility(View.INVISIBLE);
                p3.setVisibility(View.INVISIBLE);
                p4.setVisibility(View.INVISIBLE);
                p5.setVisibility(View.INVISIBLE);
                m1.setVisibility(View.INVISIBLE);
                m2.setVisibility(View.INVISIBLE);
                m3.setVisibility(View.INVISIBLE);
                m4.setVisibility(View.INVISIBLE);
                m5.setVisibility(View.INVISIBLE);

                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                t5.setVisibility(View.INVISIBLE);
                t6.setVisibility(View.INVISIBLE);

                del_imbtn.setVisibility(View.INVISIBLE);
                don.setVisibility(View.GONE);
                edit.setVisibility(View.VISIBLE);

                textname.setText(edtName.getText());
                edtName.setVisibility(View.GONE);
                textname.setVisibility(View.VISIBLE);

                textnote.setText(edtNotes.getText());
                edtNotes.setVisibility(View.GONE);
                textnote.setVisibility(View.VISIBLE);
                if (edtNotes.getText().length() == 0) {
                    t6.setChecked(false);
                }

                if (!t1.isChecked()) {
                    l1.setVisibility(View.GONE);
                }
                if (!t2.isChecked()) {
                    l2.setVisibility(View.GONE);
                }
                if (!t3.isChecked()) {
                    l3.setVisibility(View.GONE);
                }
                if (!t4.isChecked()) {
                    l4.setVisibility(View.GONE);
                }
                if (!t5.isChecked()) {
                    l5.setVisibility(View.GONE);
                }
                if (!t6.isChecked()) {
                    l6.setVisibility(View.GONE);
                }


            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);
                p3.setVisibility(View.VISIBLE);
                p4.setVisibility(View.VISIBLE);
                p5.setVisibility(View.VISIBLE);
                m1.setVisibility(View.VISIBLE);
                m2.setVisibility(View.VISIBLE);
                m3.setVisibility(View.VISIBLE);
                m4.setVisibility(View.VISIBLE);
                m5.setVisibility(View.VISIBLE);

                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);

                del_imbtn.setVisibility(View.VISIBLE);
                don.setVisibility(View.VISIBLE);
                edit.setVisibility(View.GONE);

                edtName.setText(textname.getText());
                textname.setVisibility(View.GONE);
                edtName.setVisibility(View.VISIBLE);

                edtNotes.setText(textnote.getText());
                textnote.setVisibility(View.GONE);
                edtNotes.setVisibility(View.VISIBLE);

                if (l1.getVisibility() == View.GONE) {
                    t1.setChecked(false);
                    l1.setVisibility(View.VISIBLE);
                }
                if (l2.getVisibility() == View.GONE) {
                    t2.setChecked(false);
                    l2.setVisibility(View.VISIBLE);
                }
                if (l3.getVisibility() == View.GONE) {
                    t3.setChecked(false);
                    l3.setVisibility(View.VISIBLE);
                }
                if (l4.getVisibility() == View.GONE) {
                    t4.setChecked(false);
                    l4.setVisibility(View.VISIBLE);
                }
                if (l5.getVisibility() == View.GONE) {
                    t5.setChecked(false);
                    l5.setVisibility(View.VISIBLE);
                }
                if (l6.getVisibility() == View.GONE) {
                    t6.setChecked(false);
                    l6.setVisibility(View.VISIBLE);
                }

            }
        });
    }


    public void fetchData() {
        finalMo3eedslist.clear();
        firebase.setValue(null);

        for (int i = 0; i < mContainr.getChildCount(); i++) {
            Mo3eed meed = new Mo3eed();
            LinearLayout rootv = (LinearLayout) mContainr.getChildAt(i);

            TextView tV1 = (TextView) rootv.findViewWithTag("nametag");
            meed.setMo3eedname(tV1.getText().toString());

            TextView tV2 = (TextView) rootv.findViewWithTag("shr7tag");
            meed.setShr7numb(tV2.getText().toString());

            TextView tV3 = (TextView) rootv.findViewWithTag("morag3atag");
            meed.setMorag3anum(tV3.getText().toString());

            TextView tV4 = (TextView) rootv.findViewWithTag("sectag");
            meed.setSectionsnum(tV4.getText().toString());

            TextView tV5 = (TextView) rootv.findViewWithTag("sheettag");
            meed.setSheetnumb(tV5.getText().toString());

            TextView tV6 = (TextView) rootv.findViewWithTag("emt7anatag");
            meed.setEmt7anatnum(tV6.getText().toString());

            TextView tV7 = (TextView) rootv.findViewWithTag("notetag");
            meed.setMo3ednotes(tV7.getText().toString());

            Switch t1 = (Switch) rootv.findViewWithTag("t1tag");
            if (t1.isChecked()) {
                meed.setHasshr7numb(true);
            } else {
                meed.setHasshr7numb(false);
            }
            Switch t2 = (Switch) rootv.findViewWithTag("t2tag");
            if (t2.isChecked()) {
                meed.setHasmorag3anum(true);
            } else {
                meed.setHasmorag3anum(false);
            }
            Switch t3 = (Switch) rootv.findViewWithTag("t3tag");
            if (t3.isChecked()) {
                meed.setHassectionsnum(true);
            } else {
                meed.setHassectionsnum(false);
            }
            Switch t4 = (Switch) rootv.findViewWithTag("t4tag");
            if (t4.isChecked()) {
                meed.setHassheetnumb(true);
            } else {
                meed.setHassheetnumb(false);
            }
            Switch t5 = (Switch) rootv.findViewWithTag("t5tag");
            if (t5.isChecked()) {
                meed.setHasemt7anatnum(true);
            } else {
                meed.setHasemt7anatnum(false);
            }
            Switch t6 = (Switch) rootv.findViewWithTag("t6tag");
            if (t6.isChecked()) {
                meed.setHasmo3ednotes(true);
            } else {
                meed.setHasmo3ednotes(false);
            }


            uploadData(meed);

        }

    }

    public void uploadData(Mo3eed mm) {
        firebase = new Firebase("https://engcenter.firebaseio.com/new/"+mYear+"/"+mMajor+"/"+mSubject);
        firebase.push().setValue(mm);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.editpage, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        switch (item_id) {
            case R.id.up:
                Toast.makeText(getActivity(), "uploading...", Toast.LENGTH_SHORT).show();
                fetchData();

                return true;
            case R.id.action_prev:
                ((EditInterface2) getActivity()).onPrevSelected2();

                return true;
            case R.id.action_Add:
                inflateRowbyAdd();
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Firebase.setAndroidContext(getActivity());


    }


/* for deleting dialog
    public class FireMissilesDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("are you want to delete this item ?")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

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


  */

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface EditInterface2 {
        void onPrevSelected2();
    }


}

