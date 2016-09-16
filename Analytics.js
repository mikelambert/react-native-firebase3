/**
 * @providesModule Analytics
 */
'use strict';

var { NativeModules } = require('react-native');
var FBAnalytics = NativeModules.FBAnalytics;

function setUserProperties(properties) {
  Object.keys(properties).forEach((key) => {
    FBAnalytics.setUserProperty(key, properties[key]);
  });
}

module.exports = {...FBAnalytics, setUserProperties};

