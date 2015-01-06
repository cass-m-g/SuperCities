package com.example.test3;

import com.example.test3.util.SystemUiHider;
import com.syncano.*;
import com.syncano.android.lib.*;
import com.syncano.android.lib.modules.Response;
import com.syncano.android.lib.modules.data.ParamsDataDelete;
import com.syncano.android.lib.modules.data.ParamsDataGet;
import com.syncano.android.lib.modules.data.ParamsDataNew;
import com.syncano.android.lib.modules.data.ResponseDataGet;
import com.syncano.android.lib.modules.data.ResponseDataNew;
import com.syncano.android.lib.syncserver.SyncServerConnection;
//import com.syncano.android.test.Constants;
//import com.syncano.android.test.SyncanoTest;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	private static final boolean AUTO_HIDE = true;

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	private static final boolean TOGGLE_ON_CLICK = false;

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

//	private static final String NULL = null;

	/**
	 * The instance of the {@link SystemUiHider} for this activity.
	 */
	private SystemUiHider mSystemUiHider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//final Syncano syncano = new Syncano(getBaseContext(), "super-cities", "d3fb8efd3181e128c0f93f7effb53a7db1ee69a0");

//		final String TAG = NULL;
	    final Syncano syncano;
	    Log.w("myApp", "no network1");
	        syncano = new Syncano(getBaseContext(), "super-cities", "81bb19dfb9c6b1a9fa1f8b2cdbff9236d15f25f2");
	    
		
		setContentView(R.layout.activity_main);

		final View controlsView = findViewById(R.id.fullscreen_content_control);
		final View contentView = findViewById(R.id.fullscreen_content);

		// Set up an instance of SystemUiHider to control the system UI for
		// this activity.
		mSystemUiHider = SystemUiHider.getInstance(this, contentView,
				HIDER_FLAGS);
		mSystemUiHider.setup();
		mSystemUiHider
				.setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
					// Cached values.
					int mControlsHeight;
					int mShortAnimTime;

					@Override
					@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
					public void onVisibilityChange(boolean visible) {
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
							// If the ViewPropertyAnimator API is available
							// (Honeycomb MR2 and later), use it to animate the
							// in-layout UI controls at the bottom of the
							// screen.
							if (mControlsHeight == 0) {
								mControlsHeight = controlsView.getHeight();
							}
							if (mShortAnimTime == 0) {
								mShortAnimTime = getResources().getInteger(
										android.R.integer.config_shortAnimTime);
							}
							controlsView
									.animate()
									.translationY(visible ? 0 : mControlsHeight)
									.setDuration(mShortAnimTime);
						} else {
							// If the ViewPropertyAnimator APIs aren't
							// available, simply show or hide the in-layout UI
							// controls.
							controlsView.setVisibility(visible ? View.VISIBLE
									: View.GONE);
						}

						if (visible && AUTO_HIDE) {
							// Schedule a hide().
							delayedHide(AUTO_HIDE_DELAY_MILLIS);
						}
					}
				});

		// Set up the user interaction to manually show or hide the system UI.
		contentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (TOGGLE_ON_CLICK) {
					mSystemUiHider.toggle();
				} else {
					mSystemUiHider.show();
				}
			}
		});

		// Upon interacting with UI controls, delay any scheduled hide()
		// operations to prevent the jarring behavior of controls going away
		// while interacting with the UI.
		findViewById(R.id.dummy_button).setOnTouchListener(
				mDelayHideTouchListener);
		final Context context = this;
		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	 Intent intent = new Intent(context, CrimeActivity.class);
                 startActivity(intent);   
		        // Do something in response to button click
		    	/*ParamsDataNew newObject = new ParamsDataNew("#1065", "#4604", null, "Moderated");
		    	String text = "Super Cities";
		    	newObject.setText(text);
		    	ResponseDataNew responseNew = syncano.dataNew(newObject);
		    	if(responseNew.getResultCode() == Response.CODE_SUCCESS) {
		    	    // data object successfully created
		    	}*/
		    	//SyncServerConnection conn = new SyncServerConnection(getBaseContext(),
		    		//	"super-cities", "6299834b3118f02135c91d539e380b612c740783",  (com.syncano.android.lib.syncserver.SyncServerConnection.SyncServerListener) new SyncServerListener() );

		    		//conn.start();
		        String param = "my param";
		        String val = "my value";
		        // create new object with text content

		        ParamsDataNew newObject = new ParamsDataNew("1076", "4655", null, "Moderated");
		        Log.w("myApp", "testing");
		        String text = "Test content";
		        newObject.setText(text);
		        newObject.addParam(param, val);
		        ResponseDataNew responseNew = syncano.dataNew(newObject);
		        Log.w("myApp", "no network");
		        //assertTrue(responseNew.getResultCode() == Response.CODE_SUCCESS);
		    }
		});
	}
/*public final static String TAG = SyncanoTest.class.getSimpleName();
    private Syncano syncano;

    @Override
    protected void setUp() throws Exception {
        syncano = new Syncano(getInstrumentation().getContext(), Constants.INSTANCE_NAME, Constants.API_KEY);
    }

    public void testDataSimpleOperations() {
        String param = "my param";
        String val = "my value";
        // create new object with text content
        ParamsDataNew newObject = new ParamsDataNew(Constants.PROJECT_ID, Constants.COLLECTION_ID, null, "Moderated");
        String text = "Test content";
        newObject.setText(text);
        newObject.addParam(param, val);
        ResponseDataNew responseNew = syncano.dataNew(newObject);
        assertTrue(responseNew.getResultCode() == Response.CODE_SUCCESS);

        // download created object
        String createdObjectId = responseNew.getData().getId();
        ParamsDataGet getObject = new ParamsDataGet(Constants.PROJECT_ID, Constants.COLLECTION_ID, null);
        getObject.setDataIds(new String[] {
            createdObjectId
        });
        ResponseDataGet responseGet = syncano.dataGet(getObject);
        assertTrue(val.equals(responseGet.getData()[0].getAdditional().get(param)));
        assertTrue(responseGet.getResultCode() == Response.CODE_SUCCESS);
        assertTrue(text.equals(responseGet.getData()[0].getText()));

        // remove object
        ParamsDataDelete delete = new ParamsDataDelete(Constants.PROJECT_ID, Constants.COLLECTION_ID, null);
        delete.setDataIds(new String[] {
            createdObjectId
        });
        Response responseDelete = syncano.dataDelete(delete);
        assertTrue(responseDelete.getResultCode() == Response.CODE_SUCCESS);
    }
}*/
	
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Trigger the initial hide() shortly after the activity has been
		// created, to briefly hint to the user that UI controls
		// are available.
		delayedHide(100);
	}

	/**
	 * Touch listener to use for in-layout UI controls to delay hiding the
	 * system UI. This is to prevent the jarring behavior of controls going away
	 * while interacting with activity UI.
	 */
	View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View view, MotionEvent motionEvent) {
			
			if (AUTO_HIDE) {
				delayedHide(AUTO_HIDE_DELAY_MILLIS);
			}
			return false;
		}
	};

	Handler mHideHandler = new Handler();
	Runnable mHideRunnable = new Runnable() {
		@Override
		public void run() {
			mSystemUiHider.hide();
		}
	};

		
	/**
	 * Schedules a call to hide() in [delay] milliseconds, canceling any
	 * previously scheduled calls.
	 */
	private void delayedHide(int delayMillis) {
		mHideHandler.removeCallbacks(mHideRunnable);
		mHideHandler.postDelayed(mHideRunnable, delayMillis);
	}
}
