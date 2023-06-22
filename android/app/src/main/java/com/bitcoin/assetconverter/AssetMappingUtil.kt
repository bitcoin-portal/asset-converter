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
            val assetManager = context.assets
            val json = Json { ignoreUnknownKeys = true }
            return when(T::class.java) {
                BanxaAssetMapping::class.java -> {
                        assetManager.open("banxa.json").use {
                            json.decodeFromStream<BanxaAssetMapping>(it) as T
                        }
                }
                MoonpayAssetMapping::class.java -> {
                        assetManager.open("moonpay.json").use {
                            json.decodeFromStream<MoonpayAssetMapping>(it) as T
                        }
                }
                SimplexAssetMapping::class.java -> {
                        assetManager.open("simplex.json").use {
                            json.decodeFromStream<SimplexAssetMapping>(it) as T
                        }
                }
                else -> null
            }
        }
    }
}