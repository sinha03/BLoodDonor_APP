package myapps.mbp_life.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Heroes {
    @SerializedName("data")
    private ArrayList<Hero> heros;

    public ArrayList<Hero> getHeros() {
        return heros;
    }

    public void setHeros(ArrayList<Hero> heros) {
        this.heros = heros;
    }
}