package com.example.hardware;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Flash extends AppCompatActivity {
    ImageButton btnSwitch;
    private CameraManager mCameraManager;
    private String mCameraId;
    private ImageButton mTorchOnOffButton;
    private boolean isTorchOn;
    private MediaPlayer mp;

    //	private Camera camera;
//	private boolean isFlashOn;
//	private boolean hasFlash;
//	Parameters params;
//	MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
//		// flash switch button
        mTorchOnOffButton = (ImageButton) findViewById(R.id.btnSwitch);

        Boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isFlashAvailable) {

            AlertDialog alert = new AlertDialog.Builder(Flash.this)
                    .create();
            alert.setTitle("Error !!");
            alert.setMessage("Your device doesn't support flash light!");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // closing the application
                            finish();
                            System.exit(0);
                        }
                    });
            alert.show();
            return;
        }

        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            mCameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        mTorchOnOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isTorchOn) {
                        turnOffFlashLight();
                        isTorchOn = false;
                    } else {
                        turnOnFlashLight();
                        isTorchOn = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void turnOnFlashLight() {

        try {

            mCameraManager.setTorchMode(mCameraId, true);
            playOnOffSound();
            mTorchOnOffButton.setImageResource(R.drawable.btn_switch_on);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void turnOffFlashLight() {

        try {

            mCameraManager.setTorchMode(mCameraId, false);
            playOnOffSound();
            mTorchOnOffButton.setImageResource(R.drawable.btn_switch_off);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playOnOffSound() {

        mp = MediaPlayer.create(Flash.this, R.raw.light_switch_off);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }
        });
        mp.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isTorchOn) {
            turnOffFlashLight();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isTorchOn) {
            turnOffFlashLight();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isTorchOn) {
            turnOnFlashLight();
        }
    }


}
