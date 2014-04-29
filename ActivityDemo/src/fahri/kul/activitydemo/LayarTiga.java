package fahri.kul.activitydemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class LayarTiga extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layar_tiga);
		
		TextView tv = (TextView) findViewById(R.id.hello3);
		tv.setText(getIntent().getStringExtra("transfer"));		
		//Toast.makeText(this, getIntent().getStringExtra("transfer"), Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layar_tiga, menu);
		return true;		
	}

}
