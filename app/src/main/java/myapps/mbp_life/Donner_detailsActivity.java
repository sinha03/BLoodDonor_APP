package myapps.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import myapps.myapplication.Adapter.APIUser;
import myapps.myapplication.Api.ApiURL;
import myapps.myapplication.Adapter.DataAdapter1;
import myapps.myapplication.Model.Hero1;
import myapps.myapplication.Model.Heroes1;
import myapps.myapplication.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 20-Dec-17.
 */
public class Donner_detailsActivity extends AppCompatActivity {

    int id;
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        id = getIntent().getIntExtra("ID", 0);
        Log.e("DonnerD ID", String.valueOf(id));


        Button loginButton = (Button) findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Donner_detailsActivity.this,About_donnerActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);

            }
        });
        listview = (ListView) findViewById(R.id.listview);

        //calling the method to display the heroes
        getHeroes1();
    }


    private void getHeroes1() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        APIUser service = retrofit.create(APIUser.class);
        Call<Heroes1> call =  service.getHeroes1();

        call.enqueue(new Callback<Heroes1>() {
            @Override
            public void onResponse(Call<Heroes1> call, Response<Heroes1> response) {
                ArrayList<Hero1> heros1 = response.body().getHeros1();

                //creating adapter object
                DataAdapter1 adapter = new DataAdapter1(getApplicationContext(), heros1);

                //adding it to adapterview flipper
                listview.setAdapter(adapter);

                //adapterViewFlipper.setFlipInterval(1000);
                //adapterViewFlipper.startFlipping();


            }

            @Override
            public void onFailure(Call<Heroes1> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }


}