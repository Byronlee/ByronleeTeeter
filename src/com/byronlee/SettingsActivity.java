package com.byronlee;

import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends Activity implements OnClickListener {
	private SharedPreferences baseSettings;
	private SharedPreferences rankingSettings;
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
        setContentView(R.layout.settings);
        
        // 创建一个共享首选项
        baseSettings = PreferenceManager.getDefaultSharedPreferences(this);
        
        // 设置震动效果
        CheckBox vibrateCheckbox = (CheckBox) findViewById(R.id.settings_vibrate);
        // 设置复选框的值,第二个参数为如果ConstantInfo.PREFERENCE_KEY_VIBRATE为空或者不存在,默认返回true
		vibrateCheckbox.setChecked(baseSettings.getBoolean(
				ConstantInfo.PREFERENCE_KEY_VIBRATE, true));
		vibrateCheckbox
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				  
					public void  onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
						
						if (isChecked) {
							baseSettings.edit().putBoolean(
									ConstantInfo.PREFERENCE_KEY_VIBRATE, true)
									.commit();
						} else {
							baseSettings.edit().putBoolean(
									ConstantInfo.PREFERENCE_KEY_VIBRATE, false)
									.commit();
						}
					}
				});
		
		// 设置声音效果
		CheckBox soundsCheckbox = (CheckBox)findViewById(R.id.settings_sounds);
		soundsCheckbox.setChecked(baseSettings.getBoolean(ConstantInfo.PREFERENCE_KEY_SOUNDS, true));
		soundsCheckbox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
			public void  onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				
				if (isChecked) {
					baseSettings.edit().putBoolean(
							ConstantInfo.PREFERENCE_KEY_SOUNDS, true)
							.commit();
					Log.e("vibrateCheckbox", "checked");
				} else {
					baseSettings.edit().putBoolean(
							ConstantInfo.PREFERENCE_KEY_SOUNDS, false)
							.commit();
					Log.e("vibrateCheckbox", "notChecked");
				}
			}
			
		});
		
		// 设置游戏前提示信息效果
		
		CheckBox showTipsCheckbox = (CheckBox) findViewById(R.id.settings_showtips);
		showTipsCheckbox.setChecked(baseSettings.getBoolean(
				ConstantInfo.PREFERENCE_KEY_SHOWTIPS, true));
		showTipsCheckbox
				.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
					
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							baseSettings.edit().putBoolean(
									ConstantInfo.PREFERENCE_KEY_SHOWTIPS, true)
									.commit();
						} else {
							baseSettings
									.edit()
									.putBoolean(
											ConstantInfo.PREFERENCE_KEY_SHOWTIPS,
											false).commit();
						}
					}
				});
		
		SeekBar seekBar = (SeekBar) findViewById(R.id.velocityController);
		seekBar.setProgress(baseSettings.getInt(ConstantInfo.PREFERENCE_KEY_POWER, 60));
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
			}
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			//  手离开进度条时
			public void onStopTrackingTouch(SeekBar seekBar) {
				baseSettings.edit().putInt(ConstantInfo.PREFERENCE_KEY_POWER, seekBar.getProgress()).commit();
			}
		});
  
		// 在data/data/share_prefs中会生成ConstantInfo.PREFERENCE_RANKING_INFO.xml文件
		rankingSettings = getSharedPreferences(
				ConstantInfo.PREFERENCE_RANKING_INFO, 0);
				
		TextView bestRecordTextView = (TextView) findViewById(R.id.settings_best_record_textview);
		bestRecordTextView.setText(""
				+ bestRecordTextView.getText()
				+ rankingSettings.getInt(
						ConstantInfo.PREFERENCE_KEY_RANKING_SCORE, 0));
		
		Button okayButton = (Button) findViewById(R.id.options_okay_button);
		okayButton.setOnClickListener(this);

		Button tipsButton = (Button) findViewById(R.id.options_tips_button);
		tipsButton.setOnClickListener(this);
        
	}
	    
	          public void onClick(View v) {

	      		switch (v.getId()) {
	      		case R.id.options_okay_button:
	      			// 结束Activity
	      			finish();
	      			break;

	      		case R.id.options_tips_button:
	      			Intent i = new Intent(this, IntroduceActivity.class);
	      			startActivity(i);
	      		}
	   }
}
