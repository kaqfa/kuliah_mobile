package fahri.lat.singletablesqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	String inpNIM, inpNama, inpEmail, inpPhone, inpIPK;

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
	
	public void saveData(View v){
		DBHandler db = new DBHandler(this);
		
		inpNIM 		= ( (EditText) findViewById(R.id.inpNIM) ).getText().toString();
		inpNama 	= ( (EditText) findViewById(R.id.inpNama) ).getText().toString();
		inpEmail 	= ( (EditText) findViewById(R.id.inpEmail) ).getText().toString();
		inpPhone 	= ( (EditText) findViewById(R.id.inpPhone) ).getText().toString();
		inpIPK 		= ( (EditText) findViewById(R.id.inpIPK) ).getText().toString();
		
		Mahasiswa newMhs = new Mahasiswa(inpNIM, inpNama, inpEmail, 
										inpPhone, Double.parseDouble(inpIPK));
		db.insertMhs(newMhs);
		System.out.println("Data saves is successfull");
	}
	
	public void showData(View v){		
		Intent it = new Intent(this, ListMahasiswa.class);
		startActivity(it);
	}

}
