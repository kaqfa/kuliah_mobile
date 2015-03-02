package com.parse.starter;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class TransactionList extends Activity {
	
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_list);
		
		lv = (ListView) findViewById(R.id.list);
		
		if(){
			
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              R.layout.fragment_task_list, android.R.id.text1, values);		
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
               int position, long id) {
              
             int itemPosition     = position;
             String  itemValue    = (String) lv.getItemAtPosition(position);
             Toast.makeText(getApplicationContext(),
                "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                .show();
           
            }

       }); 

//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
	}
	
	public List<String> getAllTransaction(){
		List<String> listTrans = new ArrayList<String>();
		
		ParseQuery<ParseObject> trans = ParseQuery.getQuery("Transaction");
		trans.whereEqualTo("user", ParseUser.getCurrentUser());
		trans.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> objList, ParseException e) {
		        if (e == null) {
		        	String textRep;
		        	for(int i = 0; i < objList.size(); i++){
		        		textRep = objList.get(i).getString("name");
		        		listTrans.add(textRep);
		        	}
		            listTrans = scoreList;
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }
		});
		
		
		return listTrans;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_task_list,
//					container, false);
//			return rootView;
//		}
//	}

}
