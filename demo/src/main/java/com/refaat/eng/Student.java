package com.refaat.eng;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ogaclejapan on 2/11/2016.
 */
public class Student implements Parcelable {

    String year;
    String major;
    String subjectName;
    String branshName;


    int yearPostion;
    int majorPostion;
    int subjectsPosition;
    int branshPostion;


    public Student() {
    }

    public String getBranshName() {
        return branshName;
    }

    public void setBranshName(String branshName) {
        this.branshName = branshName;
    }

    public int getBranshPostion() {
        return branshPostion;
    }

    public void setBranshPostion(int branshPostion) {
        this.branshPostion = branshPostion;
    }

    public Student(String year, String major, String subn) {
        this.year = year;
        this.major = major;
        this.subjectName = subn;
    }

    protected Student(Parcel in) {
        year = in.readString();
        major = in.readString();
        subjectName = in.readString();
        yearPostion = in.readInt();
        majorPostion = in.readInt();
        subjectsPosition = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getYearPostion() {
        return yearPostion;
    }

    public void setYearPostion(int yearPostion) {
        this.yearPostion = yearPostion;
    }

    public int getMajorPostion() {
        return majorPostion;
    }

    public void setMajorPostion(int majorPostion) {
        this.majorPostion = majorPostion;
    }

    public int getSubjectsPosition() {
        return subjectsPosition;
    }

    public void setSubjectsPosition(int subjectsPosition) {
        this.subjectsPosition = subjectsPosition;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(year);
        dest.writeString(major);
        dest.writeString(subjectName);
        dest.writeInt(yearPostion);
        dest.writeInt(majorPostion);
        dest.writeInt(subjectsPosition);
    }
}
