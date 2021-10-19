package myapps.mbp_life.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 21-Dec-17.
 */
public class Donners {
    @SerializedName("donners")
    private ArrayList<Donner> doners;

    public ArrayList<Donner> getDonners() {
        return doners;
    }

    public void setDonners(ArrayList<Donner> doners) {
        this.doners = doners;
    }
}
