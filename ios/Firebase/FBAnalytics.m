#import "FBAnalytics.h"
@import Firebase;

@implementation FBAnalytics
@synthesize bridge = _bridge;

RCT_EXPORT_MODULE();

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(logEvent: (NSString *)eventName
                  parameters:(NSDictionary *)parameters)
{
    [FIRAnalytics logEventWithName:eventName parameters:parameters];
}

RCT_EXPORT_METHOD(setUserProperty: (NSString *)name
                  withValue:(NSString *)value)
{
    [FIRAnalytics setUserPropertyString:value forName:name];
}

RCT_EXPORT_METHOD(setUserID: (NSString *)userID)
{
    [FIRAnalytics setUserID:userID];
}

RCT_EXPORT_METHOD(setAnalyticsCollectionEnabled: (BOOL)enabled)
{
    [[FIRAnalyticsConfiguration sharedInstance] setAnalyticsCollectionEnabled:enabled];
}

RCT_EXPORT_METHOD(setMinimumSessionDuration: (nonnull NSNumber *)seconds)
{
    [[FIRAnalyticsConfiguration sharedInstance] setMinimumSessionInterval:[seconds doubleValue]];
}

RCT_EXPORT_METHOD(setSessionTimeoutDuration: (nonnull NSNumber *)seconds)
{
    [[FIRAnalyticsConfiguration sharedInstance] setSessionTimeoutInterval:[seconds doubleValue]];
}

@end
