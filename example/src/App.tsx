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
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 200,
    height: 200,
    marginVertical: 20,
  },
});
