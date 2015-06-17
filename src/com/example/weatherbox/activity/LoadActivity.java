package com.example.weatherbox.activity;

import com.example.weatherbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class LoadActivity extends Activity {
	
	private Intent intent;

//	º”‘ÿloading ΩÁ√Ê
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.loading_image);
		
	}
	
	

}
