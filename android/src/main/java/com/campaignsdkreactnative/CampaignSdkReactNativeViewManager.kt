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
  fun setParams(view: CampaignSdkView, values: ReadableMap) {
    //Set error handler and then trigger custom event
    view.setParams(values)
  }

  @ReactProp(name = "reload")
  fun reload(view: CampaignSdkView, reload: Boolean) {
    if (reload) {
      //Reload sdk
    }
  }

  override fun getExportedCustomBubblingEventTypeConstants(): MutableMap<String, Any>? {
    val map = super.getExportedCustomBubblingEventTypeConstants()
    map?.put(
      "onError", mapOf(
        "phasedRegistrationNames" to mapOf(
          "bubbled" to "onError"
        )
      )
    )
    return map
  }
}
