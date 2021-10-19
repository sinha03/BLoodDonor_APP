package myapps.mbp_life;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.mbp_life.Adaptar.DataAdapter;
import myapps.mbp_life.Api.ApiService;
import myapps.mbp_life.Api.ApiURL;
import myapps.mbp_life.Model.Hero;
import myapps.mbp_life.Model.Heroes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DonorlistActivity extends AppCompatActivity {


    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listview = (ListView) findViewById(R.id.listview);
        getHeroes();
    }

    private void getHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<Heroes> call =  api.getHeroes();

        call.enqueue(new Callback<Heroes>() {
            @Override
            public void onResponse(Call<Heroes> call, Response<Heroes> response) {
                ArrayList<Hero> heros = response.body().getHeros();

                //creating adapter object
                DataAdapter adapter = new DataAdapter(getApplicationContext(), heros);

                //adding it to adapterview flipper
                listview.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Heroes> call, Throwable t) {
                Log.e("Erro", t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}