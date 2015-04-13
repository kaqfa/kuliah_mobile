package intent.latih.kaqfa.demointent;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn [] = new Button[6];

        btn[0] = (Button) findViewById(R.id.btn_tampil);
        btn[1] = (Button) findViewById(R.id.btn_teks);
        btn[2] = (Button) findViewById(R.id.btn_browser);
        btn[3] = (Button) findViewById(R.id.btn_camera);
        btn[4] = (Button) findViewById(R.id.btn_sms);
        btn[5] = (Button) findViewById(R.id.btn_telp);


        btn[0].setOnClickListener(this);
        btn[1].setOnClickListener(this);
        btn[2].setOnClickListener(this);
        btn[3].setOnClickListener(this);
        btn[4].setOnClickListener(this);
        btn[5].setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = null;
        EditText input = (EditText) findViewById(R.id.editText);

        if(v.getId() == R.id.btn_tampil){
            it = new Intent(this, HelloKitty.class);
        } else if (v.getId() == R.id.btn_teks) {
            it = new Intent(this, ShowText.class);
            it.putExtra("message", input.getText().toString());
        } else if (v.getId() == R.id.btn_sms) {
            it = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:08989987517"));
            it.putExtra("sms_body", input.getText().toString());
            it.setType("vnd.android-dir/mms-sms");
        } else if (v.getId() == R.id.btn_telp) {
            it = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("tel:"+input.getText().toString()));
        } else if (v.getId() == R.id.btn_browser) {
            it = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://"+input.getText().toString()));
        } else if (v.getId() == R.id.btn_camera) {
            it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        }
        startActivity(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
