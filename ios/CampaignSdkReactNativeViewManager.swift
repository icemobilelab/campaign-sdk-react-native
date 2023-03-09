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

            let window = UIApplication.shared
                .connectedScenes
                .compactMap { $0 as? UIWindowScene }
                .flatMap { $0.windows }
                .first { $0.isKeyWindow }

            let campaingView = CampaignView(frame: window!.bounds)
            self.addSubview(campaingView)
        }
    }
}

struct ReactNativeCardNumberProvider : CardNumberProvider {
    let card: String

    func get() -> String {
        return self.card
    }
}
