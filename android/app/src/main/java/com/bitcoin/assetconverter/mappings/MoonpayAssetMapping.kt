package com.bitcoin.assetconverter.mappings

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class MoonpayAssetMapping(
    val assets: List<Assets>
): AssetMapping() {
    @OptIn(ExperimentalSerializationApi::class)
    @Serializable
    data class Assets (
        @JsonNames("currency_code") val currencyCode: String,
        @SerialName("android_asset_id") @JsonNames("asset_id") val assetId: String,
        @JsonNames("android_blockchain") val blockchain: String,
        @JsonNames("android_asset_protocol") val assetProtocol: String
    )
}
