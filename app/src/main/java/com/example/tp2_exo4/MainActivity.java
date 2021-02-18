package com.example.tp2_exo4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private LinearLayout linearLayout;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.linearLayout = findViewById(R.id.linearLayout);

        final SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, acc, sensorManager.SENSOR_DELAY_NORMAL);
        this.info = new TextView(this);
        this.linearLayout.addView(info);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            this.info.setText("");
            double x = event.values[0];
            double y = event.values[1];
            double z = event.values[2];

            if(x > 0)
                this.info.setText(this.info.getText() + " droite");
            else
                this.info.setText(this.info.getText() + " droite");

            if(y > 0)
                this.info.setText(this.info.getText() + " haut");
            else
                this.info.setText(this.info.getText() + " bas");

            if(z > 0)
                this.info.setText(this.info.getText() + " avance");
            else
                this.info.setText(this.info.getText() + " recule");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}