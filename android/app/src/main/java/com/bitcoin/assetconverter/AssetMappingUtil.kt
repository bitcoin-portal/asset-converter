package com.bitcoin.assetconverter

import android.content.Context
import com.bitcoin.assetconverter.mappings.AssetMapping
import com.bitcoin.assetconverter.mappings.BanxaAssetMapping
import com.bitcoin.assetconverter.mappings.MoonpayAssetMapping
import com.bitcoin.assetconverter.mappings.SimplexAssetMapping
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class AssetMappingUtil {

    companion object {

        @OptIn(ExperimentalSerializationApi::class)
        inline fun <reified T: AssetMapping> getBuyAssets(context: Context): T? {
            val json = Json { ignoreUnknownKeys = true }
            when(T::class.java) {
                BanxaAssetMapping::class.java -> {
                    val assetMappingJson = context.resources.openRawResource(R.raw.banxa)
                    val assetMapping = json.decodeFromStream<BanxaAssetMapping>(assetMappingJson)

                    return assetMapping as T
                }
                MoonpayAssetMapping::class.java -> {
                    val assetMappingJson = context.resources.openRawResource(R.raw.moonpay)
                    val assetMapping = json.decodeFromStream<MoonpayAssetMapping>(assetMappingJson)

                    return assetMapping as T
                }
                SimplexAssetMapping::class.java -> {
                    val assetMappingJson = context.resources.openRawResource(R.raw.simplex)
                    val assetMapping = json.decodeFromStream<SimplexAssetMapping>(assetMappingJson)

                    return assetMapping as T
                }
            }

            return  null
        }
    }
}