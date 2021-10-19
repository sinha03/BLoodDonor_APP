package myapps.mbp_life.Model;

/**
 * Created by comsol on 19-Dec-17.
 */
public class Hero1 {
    private String id;
    private String userdetail;

    public Hero1(String id,String userdetail){

        this.id=id;
        this.userdetail=userdetail;

    }
    public String getId() {
        return id;
    }

    public String getUserdetail() {
        return userdetail;
    }
}
