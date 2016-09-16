# react-native-firebase

Firebase3 includes a great JS API. However, it only covers the web-specific features, leaving the others for the Android and iOS specific SDKs. This wraps the relevant Firebase3 mobile SDKs to expose their features via React Native JS.

Currently, it only includes support for Firebase RemoteConfig, with support for others as I find need of them (or receive pull requests for them).

If you are looking for a React Native wrapper for firebase2 API, you can find that in the react-native-firebase NPM module.

## RemoteConfig Usage:

    import { RemoteConfig } from 'react-native-firebase3';

    RemoteConfig.setDefaults({
       blog: 'url',
    });

    #ES7 async syntax...but you can pass promises if you prefer instead.
    async function someFunction() {
        console.log('Blog URL is: ', await RemoteConfig.getString('blog'));
    }
    someFunction();

## Analytics Usage:

    import { Analytics } from 'react-native-firebase3';

    Analytics.logEvent('Event Name', {
       someProperty: 'someValue',
    });


## iOS Installation

1) Add this to your Podfile (or otherwise install Firebase manually) for the appropriate targets:

    pod 'Firebase/RemoteConfig'

2) Install and link the npm
    npm install react-native-firebase3
    rnpm link react-native-firebase3

## Android Installation

TBD: The code is written, but it hasn't been tested/debugged yet, so I make no guarantees about it working yet.

