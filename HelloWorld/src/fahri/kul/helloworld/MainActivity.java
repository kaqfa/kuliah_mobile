package fahri.kul.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import fahri.kul.helloworld.R;

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
	
	public void btnClick(View v){
		new AlertDialog.Builder(this)
	    .setTitle("Peringatan Penting")
	    .setMessage("Peringatan karena telah memencet tombol \"Click Me\"")
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // Jika ada aksi tambahan setelah tombol OK diklik
	        }
	     })	    
	     .show();
		TextView teks = (TextView) findViewById(R.id.secondText);
		teks.setText("Teks yang berubah");
	}	

}
