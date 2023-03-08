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

    @objc var apiKey: String = "" {
        didSet {
        }
    }

    @objc var cardNumber: String = "" {
        didSet {
            
        }
    }
}
