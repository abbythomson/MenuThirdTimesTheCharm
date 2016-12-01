package com.example.viola.menuthirdtimesthecharm;

import android.os.Bundle;
//import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.view.View;


public class MainActivity extends android.support.v7.app.AppCompatActivity {

    private Fragment appitizerFragment;
    private Fragment entreeFragment;
    private Fragment dessertFragment;

    private static final String TAB_KEY_INDEX = "tab_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab appitizerTab = actionBar.newTab().setText(getString(R.string.ui_tabname_appitizer));
        ActionBar.Tab entreeTab = actionBar.newTab().setText(getString(R.string.ui_tabname_entree));
        ActionBar.Tab dessertTab = actionBar.newTab().setText(getString(R.string.ui_tabname_desert));

        appitizerFragment = new AppitizerFragment();
        entreeFragment = new EntreeFragment();
        dessertFragment = new DesertFragment();

        appitizerTab.setTabListener(new MyTabsListener(appitizerFragment, getApplicationContext()));
        entreeTab.setTabListener(new MyTabsListener(entreeFragment, getApplicationContext()));
        dessertTab.setTabListener(new MyTabsListener(dessertFragment, getApplicationContext()));

        actionBar.addTab(appitizerTab);
        actionBar.addTab(entreeTab);
        actionBar.addTab(dessertTab);

        if (savedInstanceState != null) {
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX, 0));
        }
    }


    class MyTabsListener implements ActionBar.TabListener {
        public Fragment fragment;

        public MyTabsListener(Fragment f, Context context){
            fragment = f;
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft){

        }
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft){
            ft.replace(R.id.fragment_container, fragment);
        }
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft){
            ft.remove(fragment);
        }

    }



}
