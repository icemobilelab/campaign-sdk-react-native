import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { CampaignView } from 'campaign-sdk-react-native';

export default function App() {
  const sdkData = {
    apiKey: 'client1',
    cardNumber: 'card-number',
  };

  const onSdkError = () => {
    /* Do something with the error like render a new view */
  }

  return (
    <View style={styles.container}>
      <CampaignView params={sdkData} style={styles.box} onError={onSdkError} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  box: {
    width: '100%',
    height: '100%',
  },
});
