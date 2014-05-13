package fahri.lat.sugarcontact.tables;

import android.content.Context;
import com.orm.SugarRecord;

public class Contact extends SugarRecord<Contact> {
	
	public String name;
	public String phoneNumber;

	public Contact(Context arg0) {
		super(arg0);
	}

	public Contact(Context arg0, String name, String phoneNumber) {
		super(arg0);
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
}
