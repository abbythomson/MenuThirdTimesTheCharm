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

public class DesertFragment extends Fragment{
    RadioButton ice;
    RadioButton pie;
    RadioButton cookie;
    Button checkout;
    RadioGroup group;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view =inflater.inflate(R.layout.fragment_desert, container, false);

        ice = (RadioButton) view.findViewById(R.id.iceCream);
        pie = (RadioButton) view.findViewById(R.id.pie);
        cookie = (RadioButton) view.findViewById(R.id.cookie);
        group = (RadioGroup) view.findViewById(R.id.desGroup);

        final Context context = getContext();
        final SharedPreferences sharedPreferences = context.getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        ice.setChecked(sharedPreferences.getBoolean("iceKey",false));
        pie.setChecked(sharedPreferences.getBoolean("pieKey",false));
        cookie.setChecked(sharedPreferences.getBoolean("cookieKey", false));

        ice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("iceKey", isChecked);
                editor.commit();
            }
        });
        pie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("pieKey",isChecked);
                editor.commit();
            }
        });
        cookie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("cookieKey", isChecked);
                editor.commit();
            }
        });
       /* checkout = (Button) view.findViewById(R.id.calcDes);
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
