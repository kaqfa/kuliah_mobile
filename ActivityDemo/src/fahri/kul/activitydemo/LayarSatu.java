package fahri.kul.activitydemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class LayarSatu extends Activity {
	
	private static final String TAG = "Layar Satu";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// The activity is being created.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layar_satu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layar_satu, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		// The activity is about to become visible.
		super.onStart();
		Log.i(TAG, "Activity sedang di-mulai");
		notify("onStart");
	}
	
	@Override
	protected void onPause() {
		// Another activity is taking focus (this activity is about to be "paused").
		super.onPause();
		Log.i(TAG, "Activity sedang di-pause");
		notify("onPause");
	}
	
	@Override
	protected void onResume() {
		// The activity has become visible (it is now "resumed").
		super.onResume();
		Log.i(TAG, "Activity di-resum kembali");
		notify("onResume");
	}
	
	@Override
	protected void onStop() {
		// The activity is no longer visible (it is now "stopped")
		super.onStop();
		Log.i(TAG, "Activity dihentikan");
		notify("onStop");
	}
	
	@Override
	protected void onDestroy() {
		// The activity is about to be destroyed.
		super.onDestroy();
		Log.i(TAG, "hancurkan Activity");
		notify("onDestroy");
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// user navigate into the activity
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "Activity sedang mengembalikan state instance");
		notify("onRestoreInstanceState");
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// Another activity comes into foreground
		super.onRestoreInstanceState(outState);
		Log.i(TAG, "Activity sedang menyimpan state instance");
		notify("onSaveInstanceState");
	}
	
	private void notify(String methodName) {
	    String name = this.getClass().getName();
	    String[] strings = name.split("\\.");
	    Notification noti = new Notification.Builder(this)
	        .setContentTitle(methodName + " " + strings[strings.length - 1]).setAutoCancel(true)
	        .setSmallIcon(R.drawable.ic_launcher)
	        .setContentText(name).build();
	    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	    notificationManager.notify((int) System.currentTimeMillis(), noti);
	  }
	
	public void btnClick(View v){
		Intent it = new Intent(this, LayarDua.class);
		startActivity(it);
//		TextView txt = (TextView) findViewById(R.id.firstText);		
//		txt.setText("Teks yang baru telah merubah segalanya");				
	}

}
