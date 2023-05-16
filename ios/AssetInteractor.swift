import Foundation
import class Foundation.Bundle

protocol  AssetInteractorProtocol {
    /// Get list of assetIdV2 compound keys.
    func getAssetList(provider: Provider) -> [String]
    /// Get compound key of assetIdV2 if any match.
    func convertProviderAssetToAssetIdV2(asset: String, provider: Provider) -> String?
    /// Get provider currency code.
    func convertAssetIdV2ToProviderAsset(assetIdV2: String, provider: Provider) -> String?
}

final class AssetInteractor: AssetInteractorProtocol {
    var assetListDict = [Provider: [String: String]]()

    func getAssetList(provider: Provider) -> [String] {
        let cachedAssets = assetListDict[provider]
        guard cachedAssets == nil else {
            return cachedAssets?.compactMap({ $0.value }) ?? []
        }

        let fetchedList = getAssetList(provider: provider) ?? [:]
        assetListDict[provider] = fetchedList
        return fetchedList.map({ $0.value })
    }

    func convertProviderAssetToAssetIdV2(asset: String, provider: Provider) -> String? {
        let cachedAssets = assetListDict[provider]
        guard cachedAssets == nil else {
            return cachedAssets?[asset]
        }
        let fetchedList = getAssetList(provider: provider) ?? [:]
        assetListDict[provider] = fetchedList
        return fetchedList[asset]
    }

    func convertAssetIdV2ToProviderAsset(assetIdV2: String, provider: Provider) -> String? {
        // TODO: fix this
        return nil
    }

    private func getAssetList(provider: Provider) -> [String: String]? {
        let fileName = provider.rawValue
        guard let path = Bundle.main.path(forResource: fileName, ofType: "json") else {
            return nil
        }

        var convertList = [String: String]()
        guard let data = try? Data(contentsOf: URL(fileURLWithPath: path), options: .mappedIfSafe) else {
            return nil
        }
        guard let providerAssetList = try? JSONDecoder().decode(ProviderAssetList.self, from: data) else {
            return nil
        }

        providerAssetList.assets.forEach { providerAsset in
            let assetId = providerAsset.assetId
            let blockchain = providerAsset.blockchain
            let assetProtocol = providerAsset.assetProtocol
            guard let convertKey = providerAsset.compoundKey ?? providerAsset.currencyCode else {
                // TODO: check this
                return
            }
            convertList[convertKey] = "\(blockchain)-\(assetProtocol)-\(assetId)"
        }

        return convertList
    }
}
