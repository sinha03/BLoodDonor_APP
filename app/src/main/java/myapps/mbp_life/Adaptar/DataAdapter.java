package myapps.mbp_life.Adaptar;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.mbp_life.DonorlistActivity;
import myapps.mbp_life.Model.Hero;
import myapps.mbp_life.R;

public class DataAdapter extends BaseAdapter implements Filterable {
    private Context mCtx;
    private ArrayList<Hero> heros;
    private ArrayList<Hero> mFilteredList;

    public DataAdapter(Context mCtx, ArrayList<Hero> heros){
        this.mCtx = mCtx;
        this.heros = heros;
        this.mFilteredList = heros;
    }
    @Override
    public int getCount() {
        //return heros.size();
        return mFilteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        final Hero hero = heros.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.simple_list, null);
        TextView textView = (TextView) view.findViewById(R.id.name);
        textView.setText(hero.getName());
        TextView textView1 = (TextView) view.findViewById(R.id.blood_group);
        textView1.setText(hero.getBlood_group());
        TextView textView2 = (TextView) view.findViewById(R.id.location);
        textView2.setText(hero.getLocation());
        TextView textView3 = (TextView) view.findViewById(R.id.phone_number);
        // textView3.setText(hero.getPhone_number());

        if(hero.getGender().equals("MALE")) {

            textView3.setText(hero.getPhone_number());
        } else{

            textView3.setText("Contact Us");

            // textView3.setText("contact");
        }

        Button loginButton = (Button) view.findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(),DonorlistActivity.class);
                intent.putExtra("ID",hero.getId());
                Log.e("Adapter ID", String.valueOf(hero.getId()));
                parent.getContext().startActivity(intent);

            }
        });

        return view;
    }

    @Override

    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = heros;
                } else {

                    ArrayList<Hero> filteredList = new ArrayList<>();

                    for (Hero androidVersion : heros) {

                        if (androidVersion.getLocation().toLowerCase().contains(charString) || androidVersion.getName().toLowerCase().contains(charString) || androidVersion.getBlood_group().toLowerCase().contains(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Hero>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


}