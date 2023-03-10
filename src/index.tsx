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

type CampaignViewParamsProps = {
  apiKey: string;
  cardNumber: string;
  locale?: string;
  auth?: string;
  extra?: object;
}

type CampaignSdkReactNativeProps = {
  params: CampaignViewParamsProps;
  style: ViewStyle;
};

const ComponentName = 'CampaignView';

export const CampaignView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<CampaignSdkReactNativeProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
