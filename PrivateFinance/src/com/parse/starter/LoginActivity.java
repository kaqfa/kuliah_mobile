package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseAnalytics;

public class LoginActivity extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
	}
	
	public void loginAct(View v){
		Intent it = new Intent(this, InputTransaction.class);
		startActivity(it);
	}
	
	public void registerAct(View v){
		Intent it = new Intent(this, RegisterActivity.class);
		startActivity(it);
	}
}
