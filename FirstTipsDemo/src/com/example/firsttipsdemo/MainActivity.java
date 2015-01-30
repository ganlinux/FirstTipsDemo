package com.example.firsttipsdemo;

import cn.com.pangutec.ganlinux.firsttips.firsttipsview.GlobalAttr;
import cn.com.pangutec.ganlinux.firsttips.firsttipsview.TipsAttr;
import cn.com.pangutec.ganlinux.firsttips.firsttipsview.TipsImageView;
import cn.com.pangutec.ganlinux.firsttips.firsttipsview.TipsImageView.OnSkipActionListener;
import cn.com.pangutec.ganlinux.firsttips.firsttipsview.TipsImageView.OnTipsClickActionListener;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private TipsImageView tipsImageView = null;//tips控件

	private TextView textView = null;//显示文字
	private Button backButton = null;//返回按钮
	private Button homeButton = null;//主页按钮
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏,否则会错位，或者在xml里去掉标题栏
		setContentView(R.layout.activity_main);

		textView = (TextView)findViewById(R.id.news_text);
		backButton = (Button)findViewById(R.id.back_btn);
		homeButton = (Button)findViewById(R.id.home_btn);
		/***************************************************************************/
		//进入正题：
		int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽（像素，如：480px）  
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
		//创建TipsImageView
		tipsImageView = (TipsImageView)findViewById(R.id.tipsImageView);

		//注意：属性的设置应在提交显示前,否则无效

		//创建全局属性 ，这里不创建也可以，默认黑色，半透明
		GlobalAttr elseAttr = new GlobalAttr(Color.BLACK);
		//设置全局属性
		tipsImageView.setGlobalAttr(elseAttr);

		//为返回按钮生成tip属性
		TipsAttr backBtnTipsAttr = new TipsAttr("点击这里返回", 50, Color.WHITE, 50, 0, 10, Color.WHITE, GlobalAttr.TIPS_CURSOR_START_RIGHT, GlobalAttr.TIPS_CURSOR_END_LEFT,GlobalAttr.TIPS_LOCATION_RIGHT);
		//提交属性
		tipsImageView.addTips2View(backButton, backBtnTipsAttr);

		//为显示生成tip属性
		TipsAttr newsTipsAttr = new TipsAttr("新闻在这里", 50, Color.WHITE, 50, 50, 10, Color.WHITE, GlobalAttr.TIPS_CURSOR_START_CENTER_BOTTOM, GlobalAttr.TIPS_CURSOR_END_LEFT_TOP,GlobalAttr.TIPS_LOCATION_BOTTOM_RIGHT);
		//提交属性
		tipsImageView.addTips2View(textView, newsTipsAttr);

		//为滑动区域生成tip属性
		TipsAttr slideTipsAttr = new TipsAttr("<---左右滑动--->\n切换类型", 50, Color.WHITE);
		Rect rect = new Rect(screenWidth/2,screenHeight/2 , 0, 0);
		//提交属性
		tipsImageView.addArea2View(rect,slideTipsAttr);

		//为主页 按钮生成tip属性
		TipsAttr homeBtnTipsAttr = new TipsAttr("点击这里\n回到主页", 50, Color.WHITE, 50, 50, 10, Color.WHITE, GlobalAttr.TIPS_CURSOR_START_RIGHT_TOP, GlobalAttr.TIPS_CURSOR_END_LEFT_BOTTOM,GlobalAttr.TIPS_LOCATION_TOP_RIGHT);
		//提交属性
		tipsImageView.addTips2View(homeButton, homeBtnTipsAttr);
		//监听跳过事件
		tipsImageView.setOnSkipActionListener(new OnSkipActionListener() {

			@Override
			public void skipTrigger() {
				// TODO Auto-generated method stub
				Log.v("tipslog", "skipTrigger");
				Toast.makeText(MainActivity.this, "捕获了skip事件", Toast.LENGTH_SHORT).show();
			}
		});
		//监听单击事件
		tipsImageView.setOnTipsClickActionListener(new OnTipsClickActionListener() {

			@Override
			public void clickTrigger() {
				// TODO Auto-generated method stub
				Log.v("tipslog", "clickTrigger");
				Toast.makeText(MainActivity.this, "捕获了点击事件", Toast.LENGTH_SHORT).show();
			}
		});
		//自此创建完成，以下为显示和事件监听
		tipsImageView.showTips();
		/***************************************************************************/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
