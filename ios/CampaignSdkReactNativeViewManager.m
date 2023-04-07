#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(CampaignViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(params, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(onError, RCTDirectEventBlock)

@end
