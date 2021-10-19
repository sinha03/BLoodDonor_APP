package myapps.mbp_life.Model;

public class Hero {

    private String name;
    private String blood_group;
    private String location;
    private int id;
    private String gender;
    private String phone_number;

    public Hero(String name,String gender,String location, String blood_group,
                String phone_number){

        this.name=name;
        this.gender=gender;
        this.location=location;
        this.blood_group=blood_group;
        this.phone_number=phone_number;

    }
    public int getId() {
        return id;
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




}