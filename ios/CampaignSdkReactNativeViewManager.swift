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
    @objc var params: [String : String] = [:] {
        didSet {
            let campaignConfig = try! CampaignConfig.Builder()
                .withCardNumberProvider(ReactNativeCardNumberProvider(card: self.params["cardNumber"]!))
                .build(apiKey: self.params["apiKey"]!)

            IceCampaign.initialize(config: campaignConfig)
        }
    }
    
    override func reactSetFrame(_ frame: CGRect) {
        super.reactSetFrame(frame)

        let campaingView = CampaignView(frame: frame)
        self.addSubview(campaingView)
    }
}

struct ReactNativeCardNumberProvider : CardNumberProvider {
    let card: String

    func get() -> String {
        return self.card
    }
}
