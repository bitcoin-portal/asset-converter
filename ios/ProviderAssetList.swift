struct ProviderAssetList: Decodable {
    var assets: [ProviderAsset]

    enum CodingKeys: String, CodingKey {
        case assets = "assets"
    }
}

struct ProviderAsset: Decodable {
    var compoundKey: String?
    var currencyCode: String?
    var assetId: String
    var blockchain: String
    var assetProtocol: String

    enum CodingKeys: String, CodingKey {
        case compoundKey = "compound_key"
        case currencyCode = "currency_code"
        case assetId = "asset_id"
        case blockchain = "ios_blockchain"
        case assetProtocol = "ios_asset_protocol"
    }
}
