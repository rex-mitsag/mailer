package com.thought.email;

public class DetailMail {

    private DetailMail(){
        //Private constructor created to hide the implicit one
    }

    /*
     *  Following needs to be edited as per requirement
     */

    public static final String MAIL_FROM = "email1"; //Email of the sender
    public static final String MAIL_TO = "email2"; //Email of the recipient
    public static final String MAIL_SUBJECT = "Message of the Day"; //Subject of the mail

    //  URLs created in html are defined here for use in class

    public static final String HTML_QUOTE = "quote";
    public static final String HTML_AUTHOR = "author";
}
