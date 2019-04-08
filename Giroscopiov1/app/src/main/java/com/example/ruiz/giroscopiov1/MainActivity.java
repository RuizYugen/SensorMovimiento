package com.example.ruiz.giroscopiov1;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    TextView x;
    TextView y;
    TextView z;

    SensorManager sensorManager;
    Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x=findViewById(R.id.txtX);
        y=findViewById(R.id.txtY);
        z=findViewById(R.id.txtZ);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("X="+event.values[0]);
        if (event.values[0]>0){
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }else{
            getWindow().getDecorView().setBackgroundColor(Color.CYAN);
        }
        y.setText("Y="+event.values[1]);
        z.setText("Z="+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
