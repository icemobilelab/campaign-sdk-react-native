package com.campaignsdkreactnative

import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class CampaignSdkReactNativeViewManager : SimpleViewManager<CampaignSdkView>() {
  override fun getName() = "CampaignView"

  override fun createViewInstance(reactContext: ThemedReactContext): CampaignSdkView {
    return CampaignSdkView(reactContext)
  }

  @ReactProp(name = "params")
  fun cardNumber(view: CampaignSdkView, values: ReadableMap) {
    view.setParams(values)
  }
}
