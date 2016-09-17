#import "RNFIRRemoteConfig.h"
@import Firebase;

@implementation RNFIRRemoteConfig

RCT_EXPORT_MODULE();

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(setDeveloperMode: (BOOL)enabled)
{
    FIRRemoteConfig *remoteConfig = [FIRRemoteConfig remoteConfig];
    FIRRemoteConfigSettings *remoteConfigSettings = [[FIRRemoteConfigSettings alloc] initWithDeveloperModeEnabled:enabled];
    remoteConfig.configSettings = remoteConfigSettings;
}


RCT_REMAP_METHOD(activateFetched,
                 activateResolver:(RCTPromiseResolveBlock)resolve
                 activateRejecter:(RCTPromiseRejectBlock)reject)
{
    resolve([NSNumber numberWithBool:[[FIRRemoteConfig remoteConfig] activateFetched]]);
}

RCT_REMAP_METHOD(fetch,
                 fetchResolver:(RCTPromiseResolveBlock)resolve
                 fetchRejecter:(RCTPromiseRejectBlock)reject)
{
    [[FIRRemoteConfig remoteConfig] fetchWithCompletionHandler:^(FIRRemoteConfigFetchStatus status, NSError *error) {
        if (status == FIRRemoteConfigFetchStatusSuccess) {
            resolve([NSNull null]);
        } else {
            reject(@"firebase_fetch_failure",
                   [NSString stringWithFormat: @"Failed to fetch firebase remote config: %@", status],
                   error);
        }
    }];
}

RCT_EXPORT_METHOD(fetchWithExpirationDuration: (nonnull NSNumber *)cacheExpirationSeconds
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    [[FIRRemoteConfig remoteConfig] fetchWithExpirationDuration: [cacheExpirationSeconds longValue]
                                              completionHandler:^(FIRRemoteConfigFetchStatus status, NSError *error) {
        if (status == FIRRemoteConfigFetchStatusSuccess) {
            resolve([NSNull null]);
        } else {
            reject(@"firebase_fetch_failure",
                   [NSString stringWithFormat: @"Failed to fetch firebase remote config: %i", status],
                   error);
        }
    }];
}


RCT_EXPORT_METHOD(getBoolean: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
    resolve([NSNumber numberWithBool:[configValue boolValue]]);
}

RCT_EXPORT_METHOD(getBoolean: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
    resolve([NSNumber numberWithBool:[configValue boolValue]]);
}

RCT_EXPORT_METHOD(getDouble: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
    resolve([configValue numberValue]);
}

RCT_EXPORT_METHOD(getDouble: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
    resolve([configValue numberValue]);
}

RCT_EXPORT_METHOD(getLong: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
    resolve([configValue numberValue]);
}

RCT_EXPORT_METHOD(getLong: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
    resolve([configValue numberValue]);
}


RCT_EXPORT_METHOD(getNamespacedString: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
    resolve([configValue stringValue]);
}

RCT_EXPORT_METHOD(getString: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
    resolve([configValue stringValue]);
}

RCT_EXPORT_METHOD(setNamespacedDefaults: (NSDictionary *)defaults
                  withNamespace:(NSString *)namespace)
{
  [[FIRRemoteConfig remoteConfig] setDefaults:defaults namespace:namespace];
}

RCT_EXPORT_METHOD(setDefaults: (NSDictionary *)defaults)
{
  [[FIRRemoteConfig remoteConfig] setDefaults:defaults];
}


@end
