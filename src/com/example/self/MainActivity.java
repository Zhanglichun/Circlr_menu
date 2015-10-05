package com.example.self;

import java.util.logging.Level;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener{

	private ImageView icon_menu;
	private ImageView icon_home;
	
	private RelativeLayout level1;
	private RelativeLayout level2;
	private RelativeLayout level3;
	
	//三级菜单是否显示，true为显示
	private boolean isLevel3Show = true;
	private boolean isLevel2Show = true;
	private boolean isLevel1Show = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		icon_menu = (ImageView) findViewById(R.id.icon_menu);
		icon_home = (ImageView) findViewById(R.id.icon_home);
		
		level1 = (RelativeLayout) findViewById(R.id.level1);
		level2 = (RelativeLayout) findViewById(R.id.level2);
		level3 = (RelativeLayout) findViewById(R.id.level3);
		
		icon_menu.setOnClickListener(this);
		icon_home.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.icon_home:
			if(isLevel2Show){
				MyUtils.startAnimationOut(level2);
				
				if(isLevel3Show){
					MyUtils.startAnimationOut(level3,200);
					isLevel3Show = !isLevel3Show;
				}
				
			}else{
				MyUtils.startAnimationIn(level2);
			}
			isLevel2Show = !isLevel2Show;
			
			break;

		case R.id.icon_menu:
			//控制三级菜单的显示或隐藏
			if(isLevel3Show ){
				MyUtils.startAnimationOut(level3);
				
			}else{
				MyUtils.startAnimationIn(level3);
			}
			
			isLevel3Show = !isLevel3Show;
			
			break;
				
		default:
			break;
		}
	}

	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		
		if(keyCode == event.KEYCODE_MENU){
			if(isLevel1Show){
				MyUtils.startAnimationOut(level1);
				isLevel1Show = !isLevel1Show;
				if(isLevel2Show){
					MyUtils.startAnimationOut(level2,200);
					isLevel2Show = !isLevel2Show;
					if(isLevel3Show){
						MyUtils.startAnimationOut(level3,400);
						isLevel3Show = !isLevel3Show;
					}
				}
			}else{
				MyUtils.startAnimationIn(level1);
				isLevel1Show = !isLevel1Show;
				MyUtils.startAnimationIn(level2,200);
				isLevel2Show = !isLevel2Show;
				MyUtils.startAnimationIn(level3,400);
				isLevel3Show = !isLevel3Show;
				
			}
			
		}else if(keyCode == event.KEYCODE_BACK){
			finish();
		}
		return true;
	};
}
