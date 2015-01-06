package com.example.test3;

import com.syncano.android.lib.Syncano;
import com.syncano.android.lib.SyncanoBase;
import com.syncano.android.lib.modules.Response;
import com.syncano.android.lib.modules.data.ParamsDataNew;
import com.syncano.android.lib.modules.data.ResponseDataNew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CrimeActivity extends Activity {

	 
		@Override
		public void onCreate(Bundle savedInstanceState) {
			final Syncano syncano = new Syncano(getApplicationContext(), "super-cities", "eafed0b27ba45230524e045271c6998019b2e79a");
			super.onCreate(savedInstanceState);
			setContentView(R.layout.pick_crime);
	
		final Context context = this;
		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	 Intent intent = new Intent(context, PetActivity.class);
                 startActivity(intent);
     		    button.setEnabled(false);  
    		    String param = "my param";
    	        String val = "my value";
    		     ParamsDataNew newObject = new ParamsDataNew("1076", "4655", null, "Moderated");
    	        String text = "PetRelease";
    	        newObject.setText(text);
    	        newObject.addParam(param, val);
    	        syncano.sendAsyncRequest(newObject, new SyncanoBase.Callback() {
    				
    				@Override
    				public void finished(Response response) {
    					// TODO Auto-generated method stub
    					Log.w("myApp", response.getResult() + " " + response.getError());
    				}
    			});
		    }
		});
		
		final Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	 Intent intent = new Intent(context, BadInfluence.class);
                 startActivity(intent);
     		    button2.setEnabled(false);
    		    String param = "my param";
    	        String val = "my value";
    		     ParamsDataNew newObject = new ParamsDataNew("1076", "4655", null, "Moderated");
    	        String text = "BadInfluence";
    	        newObject.setText(text);
    	        newObject.addParam(param, val);
    	        syncano.sendAsyncRequest(newObject, new SyncanoBase.Callback() {
    				
    				@Override
    				public void finished(Response response) {
    					// TODO Auto-generated method stub
    					Log.w("myApp", response.getResult() + " " + response.getError());
    				}
    			});
		    }
		});
		
		final Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	 Intent intent = new Intent(context, PettyTheft.class);
                 startActivity(intent);
     		    button3.setEnabled(false);  
		    
		    String param = "my param";
	        String val = "my value";
		     ParamsDataNew newObject = new ParamsDataNew("1076", "4655", null, "Moderated");
	        String text = "PettyTheft";
	        newObject.setText(text);
	        newObject.addParam(param, val);
	        syncano.sendAsyncRequest(newObject, new SyncanoBase.Callback() {
				
				@Override
				public void finished(Response response) {
					// TODO Auto-generated method stub
					Log.w("myApp", response.getResult() + " " + response.getError());
				}
			});
	        
		    }
		});
		
        
        // create new object with text content

       /* ParamsDataNew newObject = new ParamsDataNew("1076", "4655", null, "Moderated");
        Log.w("myApp", "testing");
        String text = "Test content";
        newObject.setText(text);
        newObject.addParam(param, val);
        ResponseDataNew responseNew = syncano.dataNew(newObject);
        Log.w("myApp", "no network");*/
}
}
