package com.campaignsdkreactnative

import com.icemobile.campaign.AuthenticationProvider
import com.icemobile.campaign.CardNumberProvider
import com.icemobile.campaign.ExtraParameterProvider
import com.icemobile.campaign.LocaleProvider
import java.util.Locale

class RNCardNumberProvider(
  private val cardNumber: String
): CardNumberProvider {
  override fun get(): String = cardNumber
}

class RNLocaleProvider(
  private val locale: String
): LocaleProvider {
  override fun get(): Locale {
    val parts = locale.split("_", "-")
    if (parts.size < 2) {
      return Locale.getDefault()
    }

    return Locale(parts.first(), parts.last())
  }
}

class RNAuthenticationProvider(
  private val authorization: String
): AuthenticationProvider {
  override fun get(): String = authorization
}

class RNExtraParamProvider(
  private val params: Map<String, String>
): ExtraParameterProvider {
  override fun get(): Map<String, String> = params
}
