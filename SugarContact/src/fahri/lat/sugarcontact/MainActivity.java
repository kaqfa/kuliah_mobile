package fahri.lat.sugarcontact;

import java.util.List;

import fahri.lat.sugarcontact.tables.Contact;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Contact.deleteAll(Contact.class);
		
		Log.d("Insert: ", "Inserting ..");
		Contact contact1 = new Contact(this, "Ravi", "9100000000");
		Contact contact2 = new Contact(this, "Srinivas", "9199999999");
		Contact contact3 = new Contact(this, "Tommy", "9522222222");
		Contact contact4 = new Contact(this, "Karthik", "9533333333");
		contact1.save();
		contact2.save();
		contact3.save();
		contact4.save();
		
		Log.d("Reading: ", "Reading all contacts.."); 
		List<Contact> contacts = Contact.listAll(Contact.class);
		
		for (Contact cn : contacts) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.name + " ,Phone: " + cn.phoneNumber;
            Log.d("Name: ", log);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
