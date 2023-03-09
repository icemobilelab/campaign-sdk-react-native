package com.campaignsdkreactnative

import com.icemobile.campaign.CardNumberProvider

class ReactNativeCardNumberProvider(
  private val cardNumber: String
): CardNumberProvider {
  override fun get(): String {
    return cardNumber
  }
}
