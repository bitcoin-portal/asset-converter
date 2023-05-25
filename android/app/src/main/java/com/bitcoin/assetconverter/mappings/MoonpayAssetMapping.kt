package com.bitcoin.assetconverter.mappings

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class MoonpayAssetMapping(
    val assets: List<Assets>
): AssetMapping() {
    @Serializable
    data class Assets (
        @JsonNames("currency_code") val currencyCode: String,
        @JsonNames("asset_id") val assetId: String,
        @JsonNames("android_blockchain") val blockchain: String,
        @JsonNames("android_asset_protocol") val assetProtocol: String
    )
}