import {
  requireNativeComponent,
  UIManager,
  Platform,
  ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package 'campaign-sdk-react-native' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

type CampaignSdkReactNativeProps = {
  color: string;
  style: ViewStyle;
};

const ComponentName = 'CampaignSdkReactNativeView';

export const CampaignSdkReactNativeView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<CampaignSdkReactNativeProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
