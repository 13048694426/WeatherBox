package com.example.weatherbox.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class WeatherBoxOpenHelper extends SQLiteOpenHelper {
	
	private static final String CREATE_PROVINCE = "create table Province (" + "province_name text)";
	
	private static final String CREATE_CITY = "create table City (" + "province_name text," 
			+ "city_name text)";
	private static final String CREATE_DISTRICT = "create table District (" + "id integer," 
			+"province_name text," 
			+ "city_name text,"
			+ "district_name)";
	
	public WeatherBoxOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_DISTRICT);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
