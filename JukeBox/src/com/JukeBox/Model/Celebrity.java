package com.JukeBox.Model;

public class Celebrity {
    private int celibrityID;
    private String celibrityName;

    public Celebrity(int celibrityID, String celibrityName) {
        this.celibrityID = celibrityID;
        this.celibrityName = celibrityName;
    }

    public int getCelibrityID() {
        return celibrityID;
    }

    public void setCelibrityID(int celibrityID) {
        this.celibrityID = celibrityID;
    }

    public String getCelibrityName() {
        return celibrityName;
    }

    public void setCelibrityName(String celibrityName) {
        this.celibrityName = celibrityName;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "celibrityID=" + celibrityID +
                ", celibrityName='" + celibrityName + '\'' +
                '}';
    }
}
