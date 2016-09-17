package org.jall.reactnative.firebase;

import android.app.Activity;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.analytics.FirebaseAnalytics;

public class FIRAnalytics extends ReactContextBaseJavaModule {
    public Activity activity;

    public FIRAnalytics(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        this.activity = activity;
    }

    @Override
    public String getName() {
        return "FIRAnalytics";
    }

    @ReactMethod
    public void logEvent(final String name, final ReadableMap parameters) {
        FirebaseAnalytics.getInstance(activity).logEvent(name, Arguments.toBundle(parameters));
    }

    @ReactMethod
    public void setUserId(String id) {
        FirebaseAnalytics.getInstance(activity).setUserId(id);
    }

    @ReactMethod
    public void setUserProperty(String name, String value) {
        FirebaseAnalytics.getInstance(activity).setUserProperty(name, value);
    }


    @ReactMethod
    public void setAnalyticsCollectionEnabled(boolean enabled) {
        FirebaseAnalytics.getInstance(activity).setAnalyticsCollectionEnabled(enabled);
    }

    @ReactMethod
    public void setMinimumSessionDuration(double seconds) {
        FirebaseAnalytics.getInstance(activity).setMinimumSessionDuration((long)(seconds * 1000));
    }

    @ReactMethod
    public void setSessionTimeoutDuration(double seconds) {
        FirebaseAnalytics.getInstance(activity).setSessionTimeoutDuration((long)(seconds * 1000));
    }

}
