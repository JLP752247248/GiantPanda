package com.panda.base.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testZZ {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String s[]=new String[100];
		s[0]="����34534��\n\\";
		s[1]="";
		s[2]="";
		s[3]="";
		s[4]="";
		s[5]="";
		s[6]="";
		s[7]="";
		s[8]="";
		s[9]="";
		s[10]="";
		s[11]="";
		s[12]="";
		s[13]="";
		s[14]="";
		s[15]="";
		
		int i=0;
		while(!s[i].isEmpty()){
			i++;
			System.out.println(s[i-1]);
			System.out.println(s[i-1].matches("^([\u0391-\uFFE5]|[0-9])+\n\\\\$")); 
		}
		
	}
}
