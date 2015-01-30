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
	private TipsImageView tipsImageView = null;//tips�ؼ�

	private TextView textView = null;//��ʾ����
	private Button backButton = null;//���ذ�ť
	private Button homeButton = null;//��ҳ��ť
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������,������λ��������xml��ȥ��������
		setContentView(R.layout.activity_main);

		textView = (TextView)findViewById(R.id.news_text);
		backButton = (Button)findViewById(R.id.back_btn);
		homeButton = (Button)findViewById(R.id.home_btn);
		/***************************************************************************/
		//�������⣺
		int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();       // ��Ļ�����أ��磺480px��  
		int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
		//����TipsImageView
		tipsImageView = (TipsImageView)findViewById(R.id.tipsImageView);

		//ע�⣺���Ե�����Ӧ���ύ��ʾǰ,������Ч

		//����ȫ������ �����ﲻ����Ҳ���ԣ�Ĭ�Ϻ�ɫ����͸��
		GlobalAttr elseAttr = new GlobalAttr(Color.BLACK);
		//����ȫ������
		tipsImageView.setGlobalAttr(elseAttr);

		//Ϊ���ذ�ť����tip����
		TipsAttr backBtnTipsAttr = new TipsAttr("������ﷵ��", 50, Color.WHITE, 50, 0, 10, Color.WHITE, GlobalAttr.TIPS_CURSOR_START_RIGHT, GlobalAttr.TIPS_CURSOR_END_LEFT,GlobalAttr.TIPS_LOCATION_RIGHT);
		//�ύ����
		tipsImageView.addTips2View(backButton, backBtnTipsAttr);

		//Ϊ��ʾ����tip����
		TipsAttr newsTipsAttr = new TipsAttr("����������", 50, Color.WHITE, 50, 50, 10, Color.WHITE, GlobalAttr.TIPS_CURSOR_START_CENTER_BOTTOM, GlobalAttr.TIPS_CURSOR_END_LEFT_TOP,GlobalAttr.TIPS_LOCATION_BOTTOM_RIGHT);
		//�ύ����
		tipsImageView.addTips2View(textView, newsTipsAttr);

		//Ϊ������������tip����
		TipsAttr slideTipsAttr = new TipsAttr("<---���һ���--->\n�л�����", 50, Color.WHITE);
		Rect rect = new Rect(screenWidth/2,screenHeight/2 , 0, 0);
		//�ύ����
		tipsImageView.addArea2View(rect,slideTipsAttr);

		//Ϊ��ҳ ��ť����tip����
		TipsAttr homeBtnTipsAttr = new TipsAttr("�������\n�ص���ҳ", 50, Color.WHITE, 50, 50, 10, Color.WHITE, GlobalAttr.TIPS_CURSOR_START_RIGHT_TOP, GlobalAttr.TIPS_CURSOR_END_LEFT_BOTTOM,GlobalAttr.TIPS_LOCATION_TOP_RIGHT);
		//�ύ����
		tipsImageView.addTips2View(homeButton, homeBtnTipsAttr);
		//���������¼�
		tipsImageView.setOnSkipActionListener(new OnSkipActionListener() {

			@Override
			public void skipTrigger() {
				// TODO Auto-generated method stub
				Log.v("tipslog", "skipTrigger");
				Toast.makeText(MainActivity.this, "������skip�¼�", Toast.LENGTH_SHORT).show();
			}
		});
		//���������¼�
		tipsImageView.setOnTipsClickActionListener(new OnTipsClickActionListener() {

			@Override
			public void clickTrigger() {
				// TODO Auto-generated method stub
				Log.v("tipslog", "clickTrigger");
				Toast.makeText(MainActivity.this, "�����˵���¼�", Toast.LENGTH_SHORT).show();
			}
		});
		//�Դ˴�����ɣ�����Ϊ��ʾ���¼�����
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
