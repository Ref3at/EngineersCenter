package com.refaat.eng.DetailActivity;

/**
 * Created by ogaclejapan on 2/15/2016.
 */
public class Mo3eed {

    String Mo3eedname;
    String shr7numb;
    String morag3anum;
    String sheetnumb;
    String emt7anatnum;
    String sectionsnum;
    String mo3ednotes;

    Boolean hasshr7numb;
    Boolean hasmorag3anum;
    Boolean hassheetnumb;
    Boolean hasemt7anatnum;
    Boolean hassectionsnum;
    Boolean hasmo3ednotes;



    public Boolean getHasmo3ednotes() {
        return hasmo3ednotes;
    }

    public void setHasmo3ednotes(Boolean hasmo3ednotes) {
        this.hasmo3ednotes = hasmo3ednotes;
    }

    public Boolean getHassectionsnum() {
        return hassectionsnum;
    }

    public void setHassectionsnum(Boolean hassectionsnum) {
        this.hassectionsnum = hassectionsnum;
    }

    public Boolean getHasemt7anatnum() {
        return hasemt7anatnum;
    }

    public void setHasemt7anatnum(Boolean hasemt7anatnum) {
        this.hasemt7anatnum = hasemt7anatnum;
    }

    public Boolean getHassheetnumb() {
        return hassheetnumb;
    }

    public void setHassheetnumb(Boolean hassheetnumb) {
        this.hassheetnumb = hassheetnumb;
    }

    public Boolean getHasmorag3anum() {
        return hasmorag3anum;
    }

    public void setHasmorag3anum(Boolean hasmorag3anum) {
        this.hasmorag3anum = hasmorag3anum;
    }

    public Boolean getHasshr7numb() {
        return hasshr7numb;
    }

    public void setHasshr7numb(Boolean hasshr7numb) {
        this.hasshr7numb = hasshr7numb;
    }

    public Mo3eed() {

    }

    public Mo3eed(String mo3eedname, String shr7numb, String morag3anum, String sheetnumb, String emt7anatnum, String secnum, String notes) {
        Mo3eedname = mo3eedname;
        this.shr7numb = shr7numb;
        this.morag3anum = morag3anum;
        this.sheetnumb = sheetnumb;
        this.emt7anatnum = emt7anatnum;
        this.sectionsnum = secnum;
        this.mo3ednotes = notes;
    }

    public String getMo3ednotes() {
        return mo3ednotes;
    }

    public void setMo3ednotes(String mo3ednotes) {
        this.mo3ednotes = mo3ednotes;
    }

    public String getShr7numb() {
        return shr7numb;
    }

    public void setShr7numb(String shr7numb) {
        this.shr7numb = shr7numb;
    }

    public String getMorag3anum() {
        return morag3anum;
    }

    public void setMorag3anum(String morag3anum) {
        this.morag3anum = morag3anum;
    }

    public String getSheetnumb() {
        return sheetnumb;
    }

    public void setSheetnumb(String sheetnumb) {
        this.sheetnumb = sheetnumb;
    }

    public String getEmt7anatnum() {
        return emt7anatnum;
    }

    public void setEmt7anatnum(String emt7anatnum) {
        this.emt7anatnum = emt7anatnum;
    }

    public String getMo3eedname() {
        return Mo3eedname;
    }

    public void setMo3eedname(String mo3eedname) {
        Mo3eedname = mo3eedname;
    }

    public String getSectionsnum() {
        return sectionsnum;
    }

    public void setSectionsnum(String sectionsnum) {
        this.sectionsnum = sectionsnum;
    }
}
