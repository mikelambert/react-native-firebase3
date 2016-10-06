package org.jall.reactnative.firebase;

import android.app.Activity;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.analytics.FirebaseAnalytics;

import javax.annotation.Nullable;

public class RNFIRAnalytics extends ReactContextBaseJavaModule {
    public RNFIRAnalytics(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNFIRAnalytics";
    }

    @ReactMethod
    public void logEvent(final String name, @Nullable final ReadableMap parameters) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).logEvent(name, Arguments.toBundle(parameters));
    }

    @ReactMethod
    public void setUserId(String id) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setUserId(id);
    }

    @ReactMethod
    public void setUserProperty(String name, String value) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setUserProperty(name, value);
    }


    @ReactMethod
    public void setAnalyticsCollectionEnabled(boolean enabled) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setAnalyticsCollectionEnabled(enabled);
    }

    @ReactMethod
    public void setMinimumSessionDuration(double seconds) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setMinimumSessionDuration((long)(seconds * 1000));
    }

    @ReactMethod
    public void setSessionTimeoutDuration(double seconds) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setSessionTimeoutDuration((long)(seconds * 1000));
    }

}
