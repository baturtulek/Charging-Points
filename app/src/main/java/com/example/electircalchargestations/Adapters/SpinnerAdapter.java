package com.example.electircalchargestations.Adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.electircalchargestations.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<String> {

    private Context             context;
    private int                 layoutResourceId;
    private ArrayList<String>   spinnerItemValues;

    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List values) {
        super(context, resource, values);
        this.context = context;
        this.layoutResourceId = resource;
        spinnerItemValues = (ArrayList<String>) values;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        LayoutInflater layoutInflater;

        if(rowView == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = layoutInflater.inflate(layoutResourceId, parent,false);
        }

        TextView tv_country = rowView.findViewById(R.id.tv_country);
        tv_country.setText(spinnerItemValues.get(position));
        return rowView;
    }
}
