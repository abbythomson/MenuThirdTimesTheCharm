package com.example.viola.menuthirdtimesthecharm;

/**
 * Created by viola on 11/30/2016.
 */
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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.content.Context.MODE_PRIVATE;

public class EntreeFragment extends Fragment {
    RadioButton burger;
    RadioButton sandwhich;
    RadioButton macNcheese;
    Button checkout;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_entree, container, false);
        final Context context = getContext();
        final SharedPreferences sharedPreferences = context.getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        burger = (RadioButton) view.findViewById(R.id.burger);
        sandwhich = (RadioButton) view.findViewById(R.id.sandwich);
        macNcheese = (RadioButton) view.findViewById(R.id.cheese);

        burger.setChecked(sharedPreferences.getBoolean("brgerKey",false));
        sandwhich.setChecked(sharedPreferences.getBoolean("sandKey", false));
        macNcheese.setChecked(sharedPreferences.getBoolean("cheeseKey", false));

        burger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("burgerKey", isChecked);
                editor.commit();
            }
        });
        sandwhich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("sandKey", isChecked);
                editor.commit();
            }
        });
        macNcheese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("cheeseKey", isChecked);
                editor.commit();
            }
        });
        /*checkout = (Button) view.findViewById(R.id.calcEnt);
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
