package com.campaignsdkreactnative

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class CampaignSdkReactNativeViewManager : SimpleViewManager<CampaignSdkView>() {
  override fun getName() = "CampaignView"

  override fun createViewInstance(reactContext: ThemedReactContext): CampaignSdkView {
    return CampaignSdkView(reactContext)
  }

  @ReactProp(name = "cardNumber")
  fun cardNumber(view: CampaignSdkView, cardNumber: String) {
    view.setCardNumber(cardNumber)
  }

  @ReactProp(name = "apiKey")
  fun apiKey(view: CampaignSdkView, apiKey: String) {
    view.setApiKey(apiKey)
  }
}
