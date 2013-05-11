package com.byronlee;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class main extends Activity{

	public void onCreat(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//强制全屏
        //首先去掉title,就是没有title 那一行，但是还不是全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);    
        // 禁止屏幕休眠
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //去掉状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		
		
		
		
		
	}
	
	
}
