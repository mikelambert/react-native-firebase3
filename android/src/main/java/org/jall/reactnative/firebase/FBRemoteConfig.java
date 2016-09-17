package org.jall.reactnative.firebase;

import android.app.Activity;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.ReadableNativeMap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.util.ArrayList;
import java.util.HashMap;

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
    public void setDeveloperMode(boolean enabled) {
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(enabled)
                .build();
        FirebaseRemoteConfig.getInstance().setConfigSettings(configSettings);
    }

    @ReactMethod
    public void activateFetched(Promise promise) {
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
    public void getNamespacedLong(String key, String namespace, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getLong(key, namespace)
        );
    }

    @ReactMethod
    public void getLong(String key, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getLong(key)
        );
    }

    @ReactMethod
    public void getNamespacedString(String key, String namespace, Promise promise) {
        promise.resolve(
            FirebaseRemoteConfig.getInstance().getString(key, namespace)
        );
    }

    @ReactMethod
    public void getString(String key, Promise promise) {
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