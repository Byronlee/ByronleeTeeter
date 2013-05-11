package com.byronlee;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class mainActivity extends Activity{
	
	//整个游戏的 view
	private ByronleeTeeterView mByronleeTeeterView;
	
	//手机传感器的运用
	private SensorManager mSensorManager;
	private Sensor mSensor;
	private SensorEventListener mSensorEventListener;
	
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//强制全屏
        //首先去掉title,就是没有title 那一行，但是还不是全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);    
        // 禁止屏幕休眠
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //去掉状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        mByronleeTeeterView=new ByronleeTeeterView(this);
        setContentView(mByronleeTeeterView);
		
        //设置布局，在main.xml 里面声明了 game_body 是在 ByronleeTeeterView 下的
   //     mByronleeTeeterView =(ByronleeTeeterView) findViewById(R.id.game_body);
		
        Log.v("tag", "开始游戏");
        //启动重力感应服务
    	mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); //获取众多服务中的重力感应服务
		mSensorEventListener = new SensorEventListener() {  
			
			//这里随着重力感应的变化，一直持续更改，主角x轴方向的速度
			public void onSensorChanged(SensorEvent e) {
				mByronleeTeeterView.handleMoving(e.values[SensorManager.DATA_X]);
			}

			public void onAccuracyChanged(Sensor s, int accuracy) {
			}
		};
		// 注册重力感应监听
		mSensorManager.registerListener(mSensorEventListener, mSensor,
				SensorManager.SENSOR_DELAY_GAME);
	}
	
	
	@Override
	public void finish() {
		// 注销重力感应监听
		mSensorManager.unregisterListener(mSensorEventListener, mSensor);
		super.finish();
	}
        
		
		
		
		
}
	
