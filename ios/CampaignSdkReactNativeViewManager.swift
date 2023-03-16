import Campaign

@objc(CampaignViewManager)
class CampaignViewManager: RCTViewManager {

  override func view() -> (CampaignSdkView) {
    return CampaignSdkView()
  }

  @objc override static func requiresMainQueueSetup() -> Bool {
    return false
  }
}

class CampaignSdkView : UIView {
    @objc var params: [String : Any] = [:] {
        didSet {
            let campaignConfig = CampaignConfig.Builder()
                .withCardNumberProvider(RNCardNumberProvider(card: self.params["cardNumber"] as! String))

            if let locale = self.params["locale"] as? String {
                campaignConfig.withLocaleProvider(RNLocaleProvider(locale: locale))
            }

            if let authentication = self.params["auth"] as? String {
                campaignConfig.withAuthenticationProvider(RNAuthenticationProvider(authentication: authentication))
            }

            if let extraParams = self.params["extra"] as? Dictionary<String, Any> {
                campaignConfig.withExtraParameterProvider(RNExtraParamProvider(params: extraParams.mapValues { String(describing: $0) }))
            }

            IceCampaign.initialize(config: try! campaignConfig.build(apiKey: self.params["apiKey"] as! String))
        }
    }
    
    override func reactSetFrame(_ frame: CGRect) {
        super.reactSetFrame(frame)

        let campaingView = self.subviews.first as? CampaignView
        campaingView?.removeFromSuperview()
        
        self.addSubview(CampaignView(frame: frame))
    }
}

struct RNCardNumberProvider : CardNumberProvider {
    let card: String

    func get() -> String {
        return self.card
    }
}

struct RNLocaleProvider: LocaleProvider {
    let locale: String

    func get() -> Locale {
        return Locale(identifier: self.locale)
    }
}

struct RNAuthenticationProvider: AuthenticationProvider {
    let authentication: String

    func get() -> String {
        return self.authentication
    }
}

struct RNExtraParamProvider: ExtraParameterProvider {
    let params: [String : String]

    func get() -> [String : String] {
        return self.params
    }
}
