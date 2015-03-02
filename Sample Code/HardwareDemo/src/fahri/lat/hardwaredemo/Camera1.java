package fahri.lat.hardwaredemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class Camera1 extends Activity {
	
	ImageView imgFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera1);
        
        imgFav = (ImageView)findViewById(R.id.imgView1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.camera1, menu);
        return true;
    }
    
    public void openCamera(View v){
    	Intent it = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
    	startActivityForResult(it, 0);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	Bitmap bmp = (Bitmap) data.getExtras().get("data");
    	imgFav.setImageBitmap(bmp);
    }
    
    public void changeCam(View v){
    	Intent it = new Intent(this, Camera2.class);
    	startActivity(it);
    }
    
}
