public final class AssetConvertor {
    static let assetInteractor = AssetInteractor()

    /// Get list of assetIdV2 compound keys.
    public static func getAssetList(provider: Provider) -> [String] {
        assetInteractor.getAssetList(provider: provider)
    }
    
    /// Get compound key of assetIdV2 if any match.
    public static func convertProviderAssetToAssetIdV2(asset: String, provider: Provider) -> String? {
        return assetInteractor.convertProviderAssetToAssetIdV2(asset: asset, provider: provider)
    }

    /// Get provider currency code.
    public static func convertAssetIdV2ToProviderAsset(assetIdV2: String, provider: Provider) -> String? {
        return nil
    }
}
