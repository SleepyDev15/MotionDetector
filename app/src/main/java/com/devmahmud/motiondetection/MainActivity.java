package com.devmahmud.motiondetection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.devmahmud.motiondetector.MotionDetector;
import com.devmahmud.motiondetector.MotionDetectorCallback;

public class MainActivity extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCameraPermission();

    }

    private void checkCameraPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},  MY_CAMERA_REQUEST_CODE);
            }else {
                detectMotion();
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                detectMotion();

            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    public void detectMotion(){
        MotionDetector motionDetector = new MotionDetector(this, (SurfaceView) findViewById(R.id.surfaceView));

        motionDetector.setMotionDetectorCallback(new MotionDetectorCallback() {
            @Override
            public void onMotionDetected() {
                Toast.makeText(MainActivity.this, "Detected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTooDark() {
                Toast.makeText(MainActivity.this, "Its Too Dark", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
