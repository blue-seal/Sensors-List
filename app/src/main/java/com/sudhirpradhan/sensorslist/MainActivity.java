package com.sudhirpradhan.sensorslist;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {
    private SensorManager mSensorManager;

    TextView tvTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTextView = findViewById(R.id.tvTextView);
        tvTextView.setMovementMethod(new ScrollingMovementMethod());


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        String tempstr = "<b>" + "This device has "+deviceSensors.size()+" sensors"+ "</b>";
        tvTextView.append(Html.fromHtml(tempstr));
        //tvTextView.append("\n");
        for (int i = 1; i <= deviceSensors.size(); i++) {
            String tempStr2 = "<b>" + i + ":" + "</b>";
            tvTextView.append("\n\n");
            tvTextView.append(Html.fromHtml(tempStr2));
            tvTextView.append("\n" + deviceSensors.get(i - 1).toString());
        }
        //String myName="made by sudhirpradhan";
        //tvTextView.append(Html.fromHtml(myName));

    }
}
