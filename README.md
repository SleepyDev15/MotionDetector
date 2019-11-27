# MotionDetector
This android library helps you to detect any motion in front of camera.
 
Dependency: 
          
     implementation 'com.github.Hijbullah-Mahmud:MotionDetector:1.0.0'



You need to add below permission 
            
     <uses-feature android:name="android.hardware.camera" />
     <uses-permission android:name="android.permission.CAMERA" />



Code: 

You have to use a surfaceView in your layout

            <SurfaceView
      
                    android:layout_weight="1"

                    android:layout_width="0dp"

                    android:layout_height="match_parent"

                    android:id="@+id/surfaceView" />
 


After pemission granted add this code to your activity. 


 
    
        MotionDetector motionDetector = new MotionDetector(this, (SurfaceView) findViewById(R.id.surfaceView));


             motionDetector.setMotionDetectorCallback(new MotionDetectorCallback() {

              @Override

              public void onMotionDetected() {


  
            }


            @Override

            public void onTooDark() {


            }

        });
