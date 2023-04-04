package com.campaignsdkreactnative

import android.content.Context
import android.widget.FrameLayout
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.icemobile.campaign.CampaignConfig
import com.icemobile.campaign.CampaignView
import com.icemobile.campaign.IceCampaign

class CampaignSdkView(context: Context): FrameLayout(context) {
  private val campaignView = CampaignView(context)

  init {
    campaignView.setErrorHandler {
      publishError()
      null
    }
  }

  private fun publishError() {
    val reactContext = context as ReactContext
    reactContext.getJSModule(RCTEventEmitter::class.java)
      .receiveEvent(id, "onError", null)
  }

  fun setParams(values: ReadableMap) {
    val config = CampaignConfig.Builder(context)
      .withCardNumberProvider(RNCardNumberProvider(values.getString("cardNumber")!!))

    values.getString("locale")?.let {
      config.withLocaleProvider(RNLocaleProvider(it))
    }

    values.getString("auth")?.let {
      config.withAuthenticationProvider(RNAuthenticationProvider(it))
    }

    values.getMap("extra")?.let { map ->
      config.withExtraParameterProvider(RNExtraParamProvider(map.toHashMap().mapValues { it.toString() }))
    }

    IceCampaign.initialize(
      config.build(values.getString("apiKey")!!)
    )

    removeAllViews()
    addView(campaignView)
  }

  fun reload() = campaignView.reload()
}
