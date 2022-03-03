package com.rgg.wementis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	private Utils()  {
		throw new IllegalStateException("Utility class");
	}

	public static String currentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		
		return formatter.format(date);
	}
}
