package fahri.kul.activitydemo;

import fahri.kul.fragment.Frag1;
import fahri.kul.fragment.Frag2;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class LayarDua extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layar_dua);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layar_dua, menu);
		return true;
	}	
	
	public void selectFragment(View v){
		Fragment fr;
		
		if(v == findViewById(R.id.btn1)){
			fr = new Frag1();
		} else {
			fr = new Frag2();
		}
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.fragment_area, fr);
		ft.commit();
	}

}
