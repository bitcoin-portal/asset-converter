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
                    return try {
                        val assetManager = context.assets
                        val inputStream = assetManager.open("banxa.json")
                        val assetMapping = json.decodeFromStream<BanxaAssetMapping>(inputStream)
                        assetMapping as T
                    }catch (e: Exception) {
                        throw e
                    }
                }
                MoonpayAssetMapping::class.java -> {
                    return try {
                        val assetManager = context.assets
                        val inputStream = assetManager.open("moonpay.json")
                        val assetMapping = json.decodeFromStream<MoonpayAssetMapping>(inputStream)
                        assetMapping as T
                    }catch (e: Exception) {
                        throw e
                    }
                }
                SimplexAssetMapping::class.java -> {
                    return try {
                        val assetManager = context.assets
                        val inputStream = assetManager.open("simplex.json")
                        val assetMapping = json.decodeFromStream<SimplexAssetMapping>(inputStream)
                        assetMapping as T
                    }catch (e: Exception) {
                        throw e
                    }
                }
            }

            return  null
        }
    }
}