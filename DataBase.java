package com.nitdelhi.finalproject;

import java.util.HashMap;


public class DataBase
{
	public static String getUserId() {
		return UserId;
	}
	public static void setUserId(String userId) {
		UserId = userId;
	}
	 static String getPassword() {
		return Password;
	}
	 static void setPassword(String password) {
		Password = password;
	}
	public static  String UserId,Password;
	public static  HashMap<String,String > CourseMap = new HashMap<String,String>();
	public static  HashMap<String,String > StudentUserMap = new HashMap<String,String>();
	public static  HashMap<String,String[][]> UserCourseMap = new HashMap<String,String[][]>();
	public static  HashMap<String,String[][]> UserAttendanceMap = new HashMap<String,String[][]>();
	public static  HashMap<String,String[][]> UserPastFeesMap = new HashMap<String,String[][]>();
	public static  HashMap<String,String[][]> UserPendingFeesMap = new HashMap<String,String[][]>();
	public static void DataBaseStart()
	{
		StudentUserMap.put("student", "student");
		StudentUserMap.put("gautam","admin");
		CourseMap.put("MAL101", "Advanced Calculus");
		CourseMap.put("MEL102", "Environmental Sciences");
		CourseMap.put("ECB202", "Solid State");
		CourseMap.put("EEB102", "Electrical Engineering");
		CourseMap.put("CSB201","Softwqare Engineering");
		String[][] s = new String[10][2];
		s[0]= new String[] {"MAL101","study"};
		s[1]= new String[] {"MEL102","exam"};
		UserCourseMap.put("gautam", s);
		String[][] s1 = new String[10][2];
		s1[0]=new String[] {"MAL101","study"};
		UserCourseMap.put("student",s1);
		String[][] sp = new String[10][2];
		sp[0]=new String[] {"MAL101","82.3"};
		sp[1]=new String[] {"MEL102","79.6"};
		UserAttendanceMap.put("gautam", sp);
		String[][] sp1 = new String[10][2];
		sp1[0]=new String[] {"MAL101","98.8"};
		UserAttendanceMap.put("student",sp1);
		String[][] q = new String[10][3];
		q[0] = new String[] {"P001","80000","Semester 4 Tution Fee"};
		q[1] = new String[] {"P002","10000","Semester 4 Hostel Fee"};
		UserPastFeesMap.put("gautam",q);
		String[][] q1 = new String[10][3];
		q1[0] = new String[] {"P001","80000","Semester 4 Tution Fee"};
		UserPastFeesMap.put("student", q1);
		String[][] p = new String[10][3];
		p[0] = new String[] {"P003","49888","Semester 4 Refundable Deposit"};
		UserPendingFeesMap.put("gautam", p);
		String[][] p1 =  new String[10][3];
		p1[0] = new String[] {"P002","10000","Semester 4 Hostel Fee"};
		p1[1] = new String[] {"P003","49888","Semester 4 Refundable Deposit"};
		UserPendingFeesMap.put("student", p1);
	}
	public static  void addStudentUserMap(String id, String password)
	{
		StudentUserMap.put(id, password);
	}
	public static void addCourseMap(String id, String name)
	{
		CourseMap.put(id, name);
	}
	public static void addUserCourseMap(String id , String[][] s)
	{
		UserCourseMap.put(id,s);
	}
	public static void addUserAttendanceMap(String id, String[][]s)
	{
		UserAttendanceMap.put(id, s);
	}
	public static void addPastFeesMap(String id,String[][]s)
	{
		UserPastFeesMap.put(id, s);
	}
	public static void removePendingFeesMap(String id ,String s)
	{
		int i =0;
		while(i<=9)
		{
		if(DataBase.UserPendingFeesMap.get(id)[i][0].equals(s))
		{
			DataBase.UserPendingFeesMap.get(id)[i][0]="";
			DataBase.UserPendingFeesMap.get(id)[i][1]="";
			DataBase.UserPendingFeesMap.get(id)[i][2]="";
			break;
		}
		else
			i++;
		}
	}
	@Override
	public String toString() {
		return "DataBase ";
	}
}
