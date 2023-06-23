package com.bitcoin.assetconverter.providers

import android.content.Context
import com.bitcoin.assetconverter.models.ProviderAssets
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class ProviderAssetManager(context: Context){

    val assets: MutableMap<ProviderType, List<ProviderAssets.Assets>> = mutableMapOf()
    init {
        val json = Json { ignoreUnknownKeys = true }
        ProviderType.values().forEach {
            val assetManager = context.assets
            assetManager.open(it.resource).use { inputStream ->
                val assetMapping: ProviderAssets = json.decodeFromStream(inputStream)
                assets[it] = assetMapping.assets
            }
        }
    }

    fun getAssets(provider: ProviderType): List<ProviderAssets.Assets>{
        return assets[provider] ?: listOf()
    }

}