package com.example.userinterface;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	
	public void changeActivity(View v) {
		Intent it; 
		if(findViewById(R.id.relLayoutBtn) == v){
			it = new Intent(this, RelativeLayout.class);
		} else if(findViewById(R.id.fragmentDemoBtn) == v){
			it = new Intent(this, FragmentDemo.class);
		} else if(findViewById(R.id.listViewBtn) == v){
			it = new Intent(this, ListViewDemo.class);
		} else {
			it = new Intent(this, RelativeLayout.class);
		}
		
		startActivity(it);
	}
    
}
