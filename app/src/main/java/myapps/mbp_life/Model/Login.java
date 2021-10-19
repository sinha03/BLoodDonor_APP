package myapps.myapplication.Model;

/**
 * Created by comsol on 20-Dec-17.
 */
public class Login {
    private String email;

    private String password;



    public Login(String email,String password){


        this.email=email;
        this.password=password;


    }

    public String getName() {
        return email;
    }

    public String getGender() {
        return password;
    }
}
