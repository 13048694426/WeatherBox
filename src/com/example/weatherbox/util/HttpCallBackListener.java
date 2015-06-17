package com.example.weatherbox.util;

public interface HttpCallBackListener {
	
	public void success(String result);
	
	public void error (Exception e);

}
