/**
 * @providesModule Analytics
 */
'use strict';

var { NativeModules } = require('react-native');
var Analytics = NativeModules.RNFIRAnalytics;

function setUserProperties(properties) {
  Object.keys(properties).forEach((key) => {
    Analytics.setUserProperty(key, properties[key]);
  });
}

function logEvent(eventName, params) {
  Analytics.logEvent(eventName, params);
}

module.exports = {
  ...Analytics,
  setUserProperties,
  logEvent,
};

