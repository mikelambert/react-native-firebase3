#import "FBRemoteConfig.h"
@import Firebase;

@implementation FBRemoteConfig
@synthesize bridge = _bridge;

RCT_EXPORT_MODULE();

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(activateFetched:(NSString *)message
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  resolve([[FIRRemoteConfig remoteConfig] activateFetched]);
}

RCT_EXPORT_METHOD(fetch,
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  [[FIRRemoteConfig remoteConfig] fetchWithCompletionHandler:^(FIRRemoteConfigFetchStatus status, NSError *error) {
    if (status == FIRRemoteConfigFetchStatusSuccess) {
      resolve();
    } else {
      reject(error);
    }
  }];
}

RCT_EXPORT_METHOD(fetchWithExpirationDuration: (long)cacheExpirationSeconds
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  [[FIRRemoteConfig remoteConfig] fetchWithExpirationDuration: cacheExpirationSeconds,
    completionHandler:^(FIRRemoteConfigFetchStatus status, NSError *error) {
      if (status == FIRRemoteConfigFetchStatusSuccess) {
        resolve();
      } else {
        reject(error);
      }
    }
  ];
}


RCT_EXPORT_METHOD(getBoolean: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
  resolve([configValue.boolValue]);
}

RCT_EXPORT_METHOD(getBoolean: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
  resolve([configValue.boolValue]);
}

RCT_EXPORT_METHOD(getDouble: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
  resolve([configValue.numberValue]);
}

RCT_EXPORT_METHOD(getDouble: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
  resolve([configValue.numberValue]);
}

RCT_EXPORT_METHOD(getLong: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
  resolve([configValue.numberValue]);
}

RCT_EXPORT_METHOD(getLong: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
  resolve([configValue.numberValue]);
}


RCT_EXPORT_METHOD(getString: (NSString *)key
                  withNamespace:(NSString *)namespace
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key namespace:namespace];
  resolve([configValue.stringValue]);
}

RCT_EXPORT_METHOD(getString: (NSString *)key
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  FIRRemoteConfigValue *configValue = [[FIRRemoteConfig remoteConfig] configValueForKey:key];
  resolve([configValue.stringValue]);
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
