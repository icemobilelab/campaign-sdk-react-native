package com.campaignsdkreactnative

import com.icemobile.campaign.CardNumberProvider

class ReactCardNumberProvider: CardNumberProvider {
  private var cardNumber: String = ""

  fun setCardNumber(cardNumber: String) {
    this.cardNumber = cardNumber
  }

  override fun get(): String {
    return cardNumber
  }
}
