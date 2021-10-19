package myapps.mbp_life.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 19-Dec-17.
 */
public class Heroes1 {

    @SerializedName("heroes1")
    private ArrayList<Hero1> heros1;

    public Heroes1(){

    }

    public ArrayList<Hero1> getHeros1(){
        return heros1;
    }

}
