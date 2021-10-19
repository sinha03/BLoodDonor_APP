package myapps.mbp_life.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by comsol on 22-Dec-17.
 */
public class Details {
    @SerializedName("error")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("details")
    private Details details;


    public Details(Boolean error, String message, Details details) {
        this.error = error;
        this.message = message;
        this.details =  details;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Details getDetails() {
        return details;
    }

}
