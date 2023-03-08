package com.campaignsdkreactnative

import android.content.Context
import android.widget.FrameLayout
import com.icemobile.campaign.CampaignConfig
import com.icemobile.campaign.CampaignView
import com.icemobile.campaign.IceCampaign

class CampaignSdkView(context: Context): FrameLayout(context) {
  private val cardNumberProvider = ReactCardNumberProvider()

  fun setCardNumber(cardNumber: String) {
    cardNumberProvider.setCardNumber(cardNumber)
  }

  fun setApiKey(apiKey: String) {
    IceCampaign.initialize(
      CampaignConfig.Builder(context)
        .withCardNumberProvider(cardNumberProvider)
        .build(apiKey)
    )

    addView(CampaignView(context))
  }
}
