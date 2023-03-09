package com.campaignsdkreactnative

import android.content.Context
import android.widget.FrameLayout
import com.facebook.react.bridge.ReadableMap
import com.icemobile.campaign.CampaignConfig
import com.icemobile.campaign.CampaignView
import com.icemobile.campaign.IceCampaign

class CampaignSdkView(context: Context): FrameLayout(context) {
  fun setParams(values: ReadableMap) {
    IceCampaign.initialize(
      CampaignConfig.Builder(context)
        .withCardNumberProvider(ReactNativeCardNumberProvider(values.getString("cardNumber")!!))
        .build(values.getString("apiKey")!!)
    )

    addView(CampaignView(context))
  }
}
