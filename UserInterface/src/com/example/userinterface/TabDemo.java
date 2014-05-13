package com.example.userinterface;

import com.example.fragments.FragmentTab;
import com.example.fragments.FragmentTab2;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.view.Menu;

public class TabDemo extends Activity {
	
	ActionBar.Tab tab1, tab2;
	Fragment fragTab1, fragTab2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frag_container);
		
		fragTab1 = new FragmentTab();
		fragTab2 = new FragmentTab2();
		
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		tab1 = actionBar.newTab().setText("Home");
		tab2 = actionBar.newTab().setText("Other");
		
		tab1.setTabListener(new TheTabListener(fragTab1));
		tab2.setTabListener(new TheTabListener(fragTab2));
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_demo, menu);
		return true;
	}

}
