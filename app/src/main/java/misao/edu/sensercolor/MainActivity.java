package misao.edu.sensercolor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        tv1 = findViewById( R.id.tv1 );

        sensorManager = (SensorManager) this.getSystemService( SENSOR_SERVICE );

//        sensorManager.registerListener( this, sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER ), SensorManager.SENSOR_DELAY_NORMAL );

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            getAccelerometer( sensorEvent );
        }
    }

    private void getAccelerometer(SensorEvent sensorEvent) {

        float value[] = sensorEvent.values;

        float x = value[0];
        float y = value[1];
        float z = value[2];

        float asr = (x*x + y*y + z*z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        long actualTime = System.currentTimeMillis();
        if (asr >= 2) {

            Random r = new Random();
            int i = r.nextInt( 9 );

            if(i==1)
            {
                tv1.setBackgroundColor( Color.YELLOW );
            }
            else if(i==2){
                tv1.setBackgroundColor( Color.BLUE );
            }else if(i==3){
                tv1.setBackgroundColor( Color.WHITE );
            }else if(i==4){
                tv1.setBackgroundColor( Color.GREEN );
            }else if(i==5){
                tv1.setBackgroundColor( Color.BLACK );
            }else if(i==6){
                tv1.setBackgroundColor( Color.CYAN );
            }else if(i==7){
                tv1.setBackgroundColor( Color.GRAY );
            }else if(i==8){
                tv1.setBackgroundColor( Color.MAGENTA );
            } else {
                tv1.setBackgroundColor( Color.LTGRAY );
            }
        }

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}



/*
宿題3つ
backgroundcolorチェンジ
imageview違う画像パターン
boom game作成
・gridビュー
・image adapter(チェック、爆発、爆発する前)
・バイブレーション
・ランダム
・image1つで9つのの画像


*/
