package myapps.mbp_life;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myapps.mbp_life.Api.ApiService;
import myapps.mbp_life.Api.ApiURL;
import myapps.mbp_life.Model.Donner;
import myapps.mbp_life.Model.Result1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 21-Dec-17.
 */
public class NewDonnerActivity extends AppCompatActivity implements View.OnClickListener{


    EditText nameEditText;
    EditText phoneEditText;
    AutoCompleteTextView locEditText,genderEditText,bloodEditText;

    Button saveButton;
    String[] gender_list ={"Male","Female"};
    String[] loc_list ={"Dhaka","Sylhet","Moulvibazar","Komolgonj","Srimongal"};
    String[] blood_list ={"A+","A-","O+","O-","AB+","AB-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdonner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,gender_list);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,loc_list);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,blood_list);


        nameEditText = (EditText) findViewById(R.id.editTextName);

        genderEditText = (AutoCompleteTextView) findViewById(R.id.editTextGender);
        genderEditText.setThreshold(1);//will start working from first character
        genderEditText.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        registerForContextMenu(genderEditText);

        locEditText = (AutoCompleteTextView) findViewById(R.id.editTextloc);
        locEditText.setThreshold(1);//will start working from first character
        locEditText.setAdapter(adapter1);


        bloodEditText = (AutoCompleteTextView) findViewById(R.id.editTextblood);
        bloodEditText.setThreshold(1);//will start working from first character
        bloodEditText.setAdapter(adapter2);

        phoneEditText = (EditText) findViewById(R.id.editTextphone);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);


    }
    private void insertDonner(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("creating donner...");
        progressDialog.show();

        //getting the user values

        String name = nameEditText.getText().toString().trim();
        String gender = genderEditText.getText().toString().trim();
        String location = locEditText.getText().toString().trim();
        String blood_group = bloodEditText.getText().toString();
        String phone_number = phoneEditText.getText().toString();

        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/
        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        ApiService service = retrofit.create(ApiService.class);

        //Defining the user object as we need to pass it with the call
       Donner doners = new Donner(name, gender, location,blood_group,phone_number);

        //defining the call
        Call<Result1> call = service.insertDonner(
                doners.getName(),
                doners.getGender(),
                doners.getLocation(),
                doners.getBlood_group(),
                doners.getPhone_number()

        );

        //calling the api
        call.enqueue(new Callback<Result1>() {

            @Override
            public void onResponse(Call<Result1> call, Response<Result1> response) {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), response.body().getMessage().toString().trim(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Result1> call, Throwable t) {
                progressDialog.dismiss();
                //Log.e("Erro", t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

 /*   private void createDonnerTable(int id) {

        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        ApiService service = retrofit.create(ApiService.class);

        //defining the call
        Call<Result> call = service.createTable(id);

        call.enqueue(new Callback<Result>() {

            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e("Erro", t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
*/

    @Override
    public void onClick(View v) {
        insertDonner();
    }



}