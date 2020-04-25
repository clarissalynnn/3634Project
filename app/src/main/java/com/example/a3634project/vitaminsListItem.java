package com.example.a3634project;

public class vitaminsListItem {
    int mVitaminsImage;
    String mVitaminsName;
    int mIntakeInput=0;

    public vitaminsListItem(int vitaminsImage, String vitaminsName, int IntakeInput){
        mVitaminsImage = vitaminsImage;
        mVitaminsName = vitaminsName;
        mIntakeInput = IntakeInput;
    }

    public int getmVitaminsImage() {
        return mVitaminsImage;
    }

    public int getmIntakeInput() { return mIntakeInput; }

    public void setmIntakeInput(int mIntakeInput) {
        this.mIntakeInput = mIntakeInput;
    }

    public String getmVitaminsName() {
        return mVitaminsName;
    }


}
