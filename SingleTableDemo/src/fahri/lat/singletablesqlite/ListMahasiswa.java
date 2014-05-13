package fahri.lat.singletablesqlite;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;

public class ListMahasiswa extends ListActivity{
	
	DBHandler db = new DBHandler(this);
	ArrayList<String> listMhs = new ArrayList<String>();
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getDataFromDB();
	
		setListAdapter(new ArrayAdapter<String>(this, 
								R.layout.list_mahasiswa, this.listMhs));
	
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
	
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    Toast.makeText(getApplicationContext(),
				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	
	}
	
	private void getDataFromDB(){
		Mahasiswa mhs;
		List<Mahasiswa> listMhs = db.getAllMhs();
		for(int i = 0; i < listMhs.size(); i++){
			mhs = listMhs.get(i);
			this.listMhs.add(mhs.get_nim()+" : "+mhs.get_nama());
		}
	}
}
