package com.neusoft.tools;

import java.sql.Timestamp;

import org.springframework.core.convert.converter.Converter;

import com.mysql.cj.util.StringUtils;

public class TimestampConverter implements Converter<String, Timestamp> {

	@Override
	public Timestamp convert(String arg0) {
		if(!StringUtils.isNullOrEmpty(arg0.trim())) {
			Timestamp timestamp = Timestamp.valueOf(arg0);
			return timestamp;
		}
		return null;
	}

}
