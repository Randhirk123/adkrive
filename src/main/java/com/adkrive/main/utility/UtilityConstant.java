package com.adkrive.main.utility;

public class UtilityConstant {

	public static final String errorNameMsg="Numerical characters Not allowed";
	public static final String emptyErrorMsg="Name should not be empty";
	public static final String emailErrorMsg="Email should be valid";
	public static final String emptyEmailMsg="Email should not be empty";
	public static final String emptyUsernameMsg="Username should not be empty";
	public static final String emptyPhoneMsg="Phone number should not be empty";
	public static final String phoneErrorMsg="Phone number should be valid,Only numerical value allowed";
	public static final String emptyCityMsg="City Field should not be empty";
	
	public static final int MAX_FAILED_ATTEMPTS = 3;
    
	public static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours
	
	public static final String adminFilePath="photo/admin/";
	
	public static final String rest_uri="/api/rest/v1/feeds";
}
