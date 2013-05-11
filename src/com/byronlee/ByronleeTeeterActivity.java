package com.byronlee;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ByronleeTeeterActivity extends Activity  implements OnClickListener  {
    /** Called when the activity is first created. */
	private SharedPreferences mBaseSettings;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //强制全屏
        //首先去掉title,就是没有title 那一行，但是还不是全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);    
        // 禁止屏幕休眠
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //去掉状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        
        //监听开始按钮
        Button startbutton=(Button) findViewById(R.id.start_game);
            startbutton.setOnClickListener(this);
        //监听游戏设置按钮
       	Button setutton = (Button) findViewById(R.id.set_game);
              setutton.setOnClickListener(this);      	       
        //监听退出按钮
       	Button outbutton = (Button) findViewById(R.id.out_game);
       	       outbutton.setOnClickListener(this);    
    }
    
    public void onClick(View v) {
    	mBaseSettings =PreferenceManager
				.getDefaultSharedPreferences(this);
		Intent i = null;
		switch (v.getId()) {
		case R.id.start_game:
			//判断设置里面是否开启，提示，默认是开启的
			if (mBaseSettings.getBoolean(ConstantInfo.PREFERENCE_KEY_SHOWTIPS,
					true)) {
				i = new Intent(this, IntroduceActivity.class);
				
			} else {
				i = new Intent(this, mainActivity.class);
			}
			break;
		case R.id.set_game:
			i = new Intent(this, SettingsActivity.class);
			break;
		case R.id.out_game:
			finish();
			return;			
		}
		if (i != null) {
			startActivity(i);
		}
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}