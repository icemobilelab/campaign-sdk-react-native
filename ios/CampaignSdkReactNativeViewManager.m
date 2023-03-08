#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(CampaignViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(apiKey, NSString)
RCT_EXPORT_VIEW_PROPERTY(cardNumber, NSString)

@end
