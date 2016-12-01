package com.example.viola.menuthirdtimesthecharm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import static android.content.Context.MODE_PRIVATE;



public class AppitizerFragment extends Fragment {
    RadioButton fry;
    RadioButton curds;
    RadioButton nachos;
    Button checkout;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_appitizer, container, false);
        final Context context = getContext();
        fry = (RadioButton) view.findViewById(R.id.fries);
        curds = (RadioButton) view.findViewById(R.id.cuds);
        nachos = (RadioButton) view.findViewById(R.id.nachos);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        fry.setChecked(sharedPreferences.getBoolean("fryKey", false));
        curds.setChecked(sharedPreferences.getBoolean("curdsKey", false));
        nachos.setChecked(sharedPreferences.getBoolean("nachoKey",false));

        fry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("fryKey",isChecked);
                editor.commit();
            }
        });
        curds.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("curdsKey", isChecked);
                editor.commit();
            }
        });
        nachos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("nachoKey", isChecked);
                editor.commit();
            }
        });
       /* checkout = (Button) view.findViewById(R.id.calcApp);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Checkout.class);
                intent.setAction(Intent.ACTION_SEND);
                RadioGroup desGroup = (RadioGroup) view.findViewById(R.id.desGroup);
                RadioGroup entGroup = (RadioGroup) view.findViewById(R.id.entGroup);
                RadioGroup appGroup = (RadioGroup) view.findViewById(R.id.appGroup);
                intent.putExtra("Dessert",""+desGroup.getCheckedRadioButtonId());
                intent.putExtra("Entree",""+entGroup.getCheckedRadioButtonId());
                intent.putExtra("App", ""+appGroup.getCheckedRadioButtonId());
                getActivity().startActivity(intent);
            }
        });*/
        return view;
    }

}
