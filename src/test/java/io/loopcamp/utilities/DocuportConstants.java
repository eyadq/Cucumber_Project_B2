package io.loopcamp.utilities;

public class DocuportConstants {

    /* ---      Credentials     --- */
    public static final String USERNAME_CLIENT = "b1g1_client@gmail.com";
    public static final String USERNAME_ADVISOR = "b1g1_advisor@gmail.com";
    public static final String USERNAME_SUPERVISOR = "b1g1_supervisor@gmail.com";
    public static final String USERNAME_EMPLOYEE = "b1g1_employee@gmail.com";
    public static final String PASSWORD= "Group1";
    public static final String USERNAME_SMITTY_WERBENJAGERMANJENSEN= "SWerbenjagermanjensen@NumberOneUnderTheSea.com";
    public static final String PASSWORD_SMITTY_WERBENJAGERMANJENSEN= "SmittyWerbenjagermanjensenHeWasNumber1";

    /* ---      Roles     --- */
    public static final String ADVISOR = "advisor";
    public static final String CLIENT = "client";
    public static final String SUPERVISOR = "supervisor";
    public static final String EMPLOYEE = "employee";

    /* ---      Home Icon     --- */
    public static final String LOGO_DOCUPORT = "Docuport";
    public static final String LOGO_SRC = "https://beta.docuport.app/img/logo.d7557277.svg";

    /* ---      Wait times     --- */
    public static final int extraSmall = 3;
    public static final int small = 5;
    public static final int medium = 7;
    public static final int large = 10;
    public static final int extraLarge = 20;

    /* ---      Password Error Messages     --- */
    public static final String ERROR_MESSAGE_FOR_EMPTY_PASSWORD = "Please enter your password";
    public static final String RESET_PASSWORD_URL = "https://beta.docuport.app/reset-password";
    public static final String RESET_PASSWORD_MESSAGE = "Enter the email address associated with your account";

    /* ---      Password Error Messages     --- */
    public static final String DOCUPORT_DATABASE_URL = ConfigurationReader.getProperty("docuport.db.url");
    public static final String DOCUPORT_DATABASE_USERNAME = ConfigurationReader.getProperty("docuport.db.username");
    public static final String DOCUPORT_DATABASE_PASSWORD = ConfigurationReader.getProperty("docuport.db.password");

    /* ---      Smitty Werbenjagermanjensen Personal Info     --- */
    public static final String SMITTY_WERBENJAGERMANJENSEN_FIRST_NAME = "Smitty";
    public static final String SMITTY_WERBENJAGERMANJENSEN_LAST_NAME = "Werbenjagermanjensen";
    public static final String SMITTY_WERBENJAGERMANJENSEN_ADVISOR = "Batch1 Group1";
    public static final String SMITTY_WERBENJAGERMANJENSEN_PHONE_NUMBER = "1-843-763-2428"; //1-TheSodaHat

    /* ---      Button Names     --- */
    public static final String BUTTON_LOG_IN = "Log in";
    public static final String BUTTON_LOG_OUT = "Log out";
    public static final String BUTTON_CONTINUE = "Continue";
    public static final String BUTTON_PROFILE = "Profile";
    public static final String BUTTON_CLIENTS = "Clients";
    public static final String BUTTON_CREATE_NEW_USER = "Create new user";

    /* ---      Label Names     --- */
    public static final String LABEL_FIRST_NAME = "First name";
    public static final String LABEL_LAST_NAME = "Last name";
    public static final String LABEL_EMAIL_ADDRESS = "Email address";
    public static final String LABEL_PHONE_NUMBER = "Phone number";
    public static final String LABEL_USERNAME_OR_EMAIL = "Username or email";
    public static final String LABEL_PASSWORD = "Password";
    public static final String LABEL_CONFIRM_PASSWORD = "Confirm password";



}
