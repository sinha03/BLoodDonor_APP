package myapps.mbp_life.Model;

/**
 * Created by comsol on 19-Dec-17.
 */
public class User {

    private int id;
    private String name;
    private String blood_group;
    private String location;
    private String gender;
    private String phone_number;


    public User(String name,String gender,String location, String blood_group,
                String phone_number){


        this.name=name;
        this.gender=gender;
        this.location=location;
        this.blood_group=blood_group;
        this.phone_number=phone_number;

    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public String getPhone_number()
    {
        return phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


