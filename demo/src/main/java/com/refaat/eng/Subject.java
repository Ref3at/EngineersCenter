package com.refaat.eng;

import com.refaat.eng.DetailActivity.Mo3eed;

import java.util.ArrayList;
import java.util.TimeZone;

/**
 * Created by ogaclejapan on 2/24/2016.
 */
public class Subject {
    public Subject() {
    }

    String SubName;
    ArrayList<Mo3eed> mo3edArray ;
    TimeZone time;

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    public ArrayList<Mo3eed> getMo3edArray() {
        return mo3edArray;
    }

    public void setMo3edArray(ArrayList<Mo3eed> mo3edArray) {
        this.mo3edArray = mo3edArray;
    }
}
