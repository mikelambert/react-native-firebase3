package org.jall.reactnative.firebase;

import android.app.Activity;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class FBRemoteConfig extends ReactContextBaseJavaModule {
    public Activity activity;

    public FBRemoteConfig(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        this.activity = activity;
    }

    @Override
    public String getName() {
        return "FBRemoteConfig";
    }

    @ReactMethod
    public boolean activateFetched(Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().activateFetched()
        );
    }

    @ReactMethod
    public void fetch() {
        FirebaseRemoteConfig.getInstance().fetch();
    }

    @ReactMethod
    public void fetchWithExpirationDuration(long cacheExpirationSeconds) {
        FirebaseRemoteConfig.getInstance().fetch(cacheExpirationSeconds);
    }

    @ReactMethod
    public void getNamespacedBoolean(String key, String namespace, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getBoolean(key, namespace)
        );
    }

    @ReactMethod
    public void getBoolean(String key, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getBoolean(key)
        );
    }

    @ReactMethod
    public void getNamespacedDouble(String key, String namespace, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getDouble(key, namespace)
        );
    }

    @ReactMethod
    public void getDouble(String key, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getDouble(key)
        );
    }

    @ReactMethod
    public boolean getNamespacedLong(String key, String namespace, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getLong(key, namespace)
        );
    }

    @ReactMethod
    public boolean getLong(String key, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getLong(key)
        );
    }

    @ReactMethod
    public boolean getNamespacedString(String key, String namespace, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getString(key, namespace)
        );
    }

    @ReactMethod
    public boolean getString(String key, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getString(key)
        );
    }

    @ReactMethod
    public void setNamespacedDefaults(final ReadableMap defaults, String namespace) {
        FirebaseRemoteConfig.getInstance().setDefaults(
            ((ReadableNativeMap)defaults).toHashMap(),
            namespace
        );
    }

    @ReactMethod
    public void setDefaults(final ReadableMap defaults) {
        FirebaseRemoteConfig.getInstance().setDefaults(
            ((ReadableNativeMap)defaults).toHashMap()
        );
    }
}