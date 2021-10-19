package myapps.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.myapplication.Model.Hero1;
import myapps.myapplication.R;

/**
 * Created by comsol on 19-Dec-17.
 */
public class DataAdapter1 extends BaseAdapter {
    private Context mCtx;
    private ArrayList<Hero1> heros1;

    public DataAdapter1(Context mCtx, ArrayList<Hero1> heros1){
        this.mCtx = mCtx;
        this.heros1 = heros1;
    }
    @Override
    public int getCount() {
        return heros1.size();
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

        Hero1 hero1 = heros1.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.simple_list1, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(hero1.getUserdetail());



        return view;
    }


}
