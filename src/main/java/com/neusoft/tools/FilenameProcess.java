package com.neusoft.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilenameProcess {
	
	public String process(String filename) {
		String newFilename = filename.trim();
		newFilename = newFilename.replaceAll("[^x00-xff]", "ZH");
		return newFilename;
	}
}
