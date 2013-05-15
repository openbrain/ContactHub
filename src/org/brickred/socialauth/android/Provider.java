package org.brickred.socialauth.android;

import org.brickred.socialauth.util.Constants;


/**
 * Enum of all supported providers
 * 
 */
public enum Provider {
    FACEBOOK(Constants.FACEBOOK, "fbconnect://success", "fbconnect://success?error_reason"), TWITTER(Constants.TWITTER, "twitterapp://connect",
            "twitterapp://connect?denied"), LINKEDIN(Constants.LINKEDIN, "http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do",
            "http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do?oauth_problem"), MYSPACE(Constants.MYSPACE, "http://socialauth.in",
            "http://socialauth.in/?oauth_problem"), RUNKEEPER(Constants.RUNKEEPER, "http://socialauth.in/socialauthdemo/socialauthSuccessAction.do",
            "http://socialauth.in/socialauthdemo/socialauthSuccessAction.do/?error"), YAHOO(Constants.YAHOO, "http://socialauth.in/socialauthdemo",
            "http://socialauth.in/socialauthdemo/?oauth_problem"), FOURSQUARE(Constants.FOURSQUARE,
            "http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do",
            "http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do/?oauth_problem"), GOOGLE(Constants.GOOGLE,
            "http://socialauth.in/socialauthdemo", "http://socialauth.in/socialauthdemo/?oauth_problem"), YAMMER(Constants.YAMMER,
            "http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do",
            "http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do/?oauth_problem"), SALESFORCE(Constants.SALESFORCE,
            "https://socialauth.in:8443/socialauthdemo/socialAuthSuccessAction.do",
            "http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do/?oauth_problem"), CALL("call", "call", "call"), MESSAGE("message",
            "message", "message"), APP("app", "app", "app"),CONTACT("contact", "contact", "contact");

    private String name;
    private String cancelUri;
    private String callbackUri;

    /**
     * Constructor with unique string representing the provider
     * 
     * @param name
     */
    Provider(String name, String callbackUri, String cancelUri) {
        this.name = name;
        this.cancelUri = cancelUri;
        this.callbackUri = callbackUri;
    }

    /**
     * returns cancel URI
     */
    String getCancelUri() {
        return this.cancelUri;
    }

    /**
     * returns Callback URI
     */
    String getCallBackUri() {
        return this.callbackUri;
    }

    /**
     * Set callback URI
     */
    public void setCallBackUri(String callbackUri) {
        this.callbackUri = callbackUri;
    }

    /**
     * Returns the unique string representing the provider
     */
    @Override
    public String toString() {
        return name;
    }
}
