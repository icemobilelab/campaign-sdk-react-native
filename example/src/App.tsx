import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { CampaignView } from 'campaign-sdk-react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <CampaignView cardNumber="card-number" apiKey="client1" style={styles.box} />
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
