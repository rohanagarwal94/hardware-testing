package com.example.hardware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hardware.adaptor.RecyclerItemClickListener;
import com.example.hardware.adaptor.RecyclerViewAdaptor;


public class MainActivity extends Activity implements RecyclerItemClickListener.OnItemClickListener{
    Intent intent;
   
	RecyclerView recyclerView;
	RecyclerView.LayoutManager mLayoutManager;
	RecyclerViewAdaptor mAdaptor;

	String items[]={"Vibration Test","Check Version Info","SIM Card","Proximity Sensor",
			        "Flash Light","Touch Sensor","Display","Light Sensor","Pressure Sensor"
			        ,"Phone Buttons","Speaker Test","Wi-Fi Address","Bluetooth Address","Gravity sensor","Magnetic Sensor","Headphone",
			        "Gyroscope","GPS Location","Battery Indicator","Accelarometer"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

			// use this setting to improve performance if you know that changes
			// in content do not change the layout size of the RecyclerView
			recyclerView.setHasFixedSize(true);
			mLayoutManager = new LinearLayoutManager(getApplicationContext());
			recyclerView.setLayoutManager(mLayoutManager);

			mAdaptor = new RecyclerViewAdaptor(getApplicationContext(), items);
			recyclerView.setAdapter(mAdaptor);
			recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),this));

		}

	@Override
	public void onItemClick(View childView, int position) {

		switch(position) {
			case 0:
				//not working
				intent = new Intent(this, Vibration.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(this, Tele.class);
				startActivity(intent);
				break;
			case 1:
				//not whole info
				intent = new Intent(getApplicationContext(), Systeminfo.class);
				startActivity(intent);
				break;
			case 3:

				intent = new Intent(getApplicationContext(), ProximitySensor.class);
				startActivity(intent);
				break;

			case 4:
				//not working
				intent = new Intent(getApplicationContext(), Flash.class);
				startActivity(intent);
				break;

			case 5:

				intent = new Intent(getApplicationContext(), TouchSensor.class);
				startActivity(intent);
				break;
			case 6:
				//display multiple lighting
				intent = new Intent(getApplicationContext(), Display.class);
				startActivity(intent);
				break;
			case 7:
				//light sensor display of dac values
				intent = new Intent(getApplicationContext(), Lightsensor.class);
				startActivity(intent);
				break;
			case 8:

				intent = new Intent(getApplicationContext(), Pressure.class);
				startActivity(intent);
				break;

			case 9:
				//wrong the volume buttons,home,menu etc has to be checked here
				intent = new Intent(getApplicationContext(), Buttontesting.class);
				startActivity(intent);
				break;
			case 10:
				//wrong should have done that while taking calling position we here our voice
				intent = new Intent(getApplicationContext(), Mictesting.class);
				startActivity(intent);
				break;
			case 11:

				intent = new Intent(getApplicationContext(), Wifiaddress.class);
				startActivity(intent);
				break;
			case 12:

				intent = new Intent(getApplicationContext(), Blueadd.class);
				startActivity(intent);
				break;
			case 13:

				intent = new Intent(getApplicationContext(), Gravitysensor.class);
				startActivity(intent);
				break;

			case 14:
				intent = new Intent(getApplicationContext(), Magneticsensor.class);
				startActivity(intent);
				break;
			case 15:
				//not working
				intent = new Intent(getApplicationContext(), Headphone.class);
				startActivity(intent);
				break;
			case 16:
				intent = new Intent(getApplicationContext(), Gyroscope.class);
				startActivity(intent);
				break;
			case 17:
				//test again
				intent = new Intent(getApplicationContext(), Gpsloc.class);
				startActivity(intent);
				break;
			case 18:
				intent = new Intent(getApplicationContext(), Batteryindicator.class);
				startActivity(intent);
				break;
			case 19:
				intent = new Intent(getApplicationContext(), Accelarometer.class);
				startActivity(intent);
				break;
		}
	}

	@Override
	public void onItemLongPress(View childView, int position) {

	}
}
		