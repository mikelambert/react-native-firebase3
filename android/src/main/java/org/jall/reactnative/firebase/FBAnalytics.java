package org.jall.reactnative.firebase;

import android.app.Activity;
import android.util.Log;

import com.crashlytics.android.answers.AddToCartEvent;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.AnswersEvent;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.answers.InviteEvent;
import com.crashlytics.android.answers.LevelEndEvent;
import com.crashlytics.android.answers.LevelStartEvent;
import com.crashlytics.android.answers.LoginEvent;
import com.crashlytics.android.answers.PredefinedEvent;
import com.crashlytics.android.answers.PurchaseEvent;
import com.crashlytics.android.answers.RatingEvent;
import com.crashlytics.android.answers.SearchEvent;
import com.crashlytics.android.answers.ShareEvent;
import com.crashlytics.android.answers.SignUpEvent;
import com.crashlytics.android.answers.StartCheckoutEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

import java.math.BigDecimal;
import java.util.Currency;

public class FBAnalytics extends ReactContextBaseJavaModule {
    public Activity activity;

    public FBAnalytics(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        this.activity = activity;
    }

    @Override
    public String getName() {
        return "FBAnalytics";
    }

    @ReactMethod
    public void logEvent(final ReadableMap eventName, final ReadableMap parameters) {
        FirebaseAnalytics.getInstance().logEvent(name, Arguments.toBundle(parameters));
    }

    @ReactMethod
    public void setUserId(String id) {
        FirebaseAnalytics.getInstance().setUserId(id);
    }

    @ReactMethod
    public void setUserProperty(String name, String value) {
        FirebaseAnalytics.getInstance().setUserProperty(name, value);
    }


    @ReactMethod
    public void setAnalyticsCollectionEnabled(boolean enabled) {
        FirebaseAnalytics.getInstance().setAnalyticsCollectionEnabled(enabled);
    }

    @ReactMethod
    public void setMinimumSessionDuration(double seconds) {
        FirebaseAnalytics.getInstance().setMinimumSessionDuration((long)(seconds * 1000));
    }

    @ReactMethod
    public void setSessionTimeoutDuration(double seconds) {
        FirebaseAnalytics.getInstance().setSessionTimeoutDuration((long)(seconds * 1000));
    }

}
