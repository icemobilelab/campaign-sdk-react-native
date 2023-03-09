import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { CampaignView } from 'campaign-sdk-react-native';

export default function App() {
  const sdkData = {
    apiKey: "client1",
    cardNumber: "card-number"
  }

  return (
    <View style={styles.container}>
      <CampaignView params={sdkData} style={styles.box} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  box: {
    width: '100%',
    height: '100%'
  },
});
