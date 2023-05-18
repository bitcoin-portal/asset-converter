public final class AssetConvertor {
    static let assetInteractor = AssetInteractor()

    /// Get list of assetIdV2 compound keys.
    public static func getAssetList(provider: Provider) -> [String] {
        assetInteractor.getAssetList(provider: provider)
    }

    /// Get provider specific compound key from assetIdV2 compound key.
    /// Check unit test for samples.
    public static func convertProviderAssetToAssetIdV2(asset: String, provider: Provider) -> String? {
        return assetInteractor.convertProviderAssetToAssetIdV2(asset: asset, provider: provider)
    }

    /// Get assetIdV2 compound key from provider specific compound key.
    /// Check unit test for samples.
    public static func convertAssetIdV2ToProviderAsset(assetIdV2: String, provider: Provider) -> String? {
        return assetInteractor.convertAssetIdV2ToProviderAsset(assetIdV2: assetIdV2, provider: provider)
    }
}
