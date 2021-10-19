package myapps.mbp_life.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by comsol on 20-Dec-17.
 */
public class Result1 {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("newdonor")
    private Donner donner;


    public Result1(Boolean error, String message, Donner donner) {
        this.error = error;
        this.message = message;
        this.donner =  donner;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Donner getDonner() {
        return donner;
    }
}
