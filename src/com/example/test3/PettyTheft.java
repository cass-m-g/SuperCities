package com.example.test3;

import com.syncano.android.lib.Syncano;
import com.syncano.android.lib.SyncanoBase;
import com.syncano.android.lib.modules.Response;
import com.syncano.android.lib.modules.data.ParamsDataNew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PettyTheft extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pettytheft);

		final Context context = this;
		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	 Intent intent = new Intent(context, WasteDump.class);
                 startActivity(intent);
     		    button.setEnabled(false);  
    		    
		    }
		});
	}
}
