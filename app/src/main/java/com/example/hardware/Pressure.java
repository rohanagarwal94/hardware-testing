package com.example.hardware;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Pressure extends AppCompatActivity implements SensorEventListener {
	 TextView tvx;
     SensorManager sensmgr;
     Sensor accsensor;
     float[] sensorvalues;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pressure);
		
		tvx=(TextView)findViewById(R.id.textView00);
		
		sensmgr=(SensorManager)getSystemService(SENSOR_SERVICE);
		accsensor=sensmgr.getDefaultSensor(Sensor.TYPE_PRESSURE);
	}

	@Override
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pressure, menu);
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

	@Override
	public void onSensorChanged(SensorEvent event) {
     sensorvalues=event.values;
     float x=sensorvalues[0];
   
     tvx.setText("x" +x+" hPa");
     
 
    
     
	}
	

	@Override
	protected void onResume() {
    sensmgr.registerListener(this,accsensor,SensorManager.SENSOR_DELAY_NORMAL);

    super.onResume();
	}
	

	@Override
	protected void onPause() {
		sensmgr.unregisterListener(this);
		super.onPause();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
