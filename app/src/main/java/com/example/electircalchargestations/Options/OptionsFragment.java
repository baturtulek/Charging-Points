package com.example.electircalchargestations.Options;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.R;

import java.util.ArrayList;

public class OptionsFragment extends Fragment {

    private Spinner maxResultSpinner;
    private Switch  openLicenseSwitch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_options,null);

        maxResultSpinner    = view.findViewById(R.id.maxResultSpinner);
        openLicenseSwitch   = view.findViewById(R.id.openLicenseSwitch);

        fillSpinner();

        maxResultSpinner.setSelection(Constants.MAX_RESULT + 1);
        maxResultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    Constants.MAX_RESULT = Integer.parseInt(maxResultSpinner.getSelectedItem().toString());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        openLicenseSwitch.setChecked(Boolean.parseBoolean(Constants.OPEN_DATA_LICENSE));
        openLicenseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Constants.OPEN_DATA_LICENSE = Boolean.toString(isChecked);
                }else{
                    Constants.OPEN_DATA_LICENSE = "";
                }
            }
        });
        return view;
    }

    private void fillSpinner(){
        ArrayList<String> spinnerArray =  new ArrayList<>();
        spinnerArray.add("Select..");
        for(int i = 0; i <= 500; i++){
            spinnerArray.add(i + "");
        }
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this.getContext(),android.R.layout.simple_spinner_item,spinnerArray);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maxResultSpinner.setAdapter(spinnerAdapter);
    }

}
