package myapps.mbp_life.Api;

import myapps.mbp_life.Model.Heroes;
import myapps.mbp_life.Model.Result1;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("newdonor.php")
    Call<Result1> insertDonner(
            @Field("name") String name,
            @Field("gender") String gender,
            @Field("location") String location,
            @Field("blood_group") String blood_group,
            @Field("phone_number") String phone_number);

   // @FormUrlEncoded
    @GET("getdata.php")
    Call<Heroes> getHeroes();


}