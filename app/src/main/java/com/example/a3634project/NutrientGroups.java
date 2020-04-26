package com.example.a3634project;

import android.os.Parcel;
import android.os.Parcelable;

public class NutrientGroups  implements Parcelable {
    private String Name;
    private String Amount;
    private String percentofDailyNeeds;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getPercentofDailyNeeds() {
        return percentofDailyNeeds;
    }

    public void setPercentofDailyNeeds(String percentofDailyNeeds) {
        this.percentofDailyNeeds = percentofDailyNeeds;
    }

    public NutrientGroups(String name, String amount, String percentofDailyNeeds){
        this.Name = name;
        this.Amount=amount;
        this.percentofDailyNeeds = percentofDailyNeeds;
    }

    protected NutrientGroups(Parcel in) {
        setName(in.readString());
    }

    public static final Creator<NutrientGroups> CREATOR = new Creator<NutrientGroups>() {
        @Override
        public NutrientGroups createFromParcel(Parcel in) {
            return new NutrientGroups(in);
        }

        @Override
        public NutrientGroups[] newArray(int size) {
            return new NutrientGroups[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(getName());
    dest.writeString(getAmount());
    dest.writeString(getPercentofDailyNeeds());}

}
