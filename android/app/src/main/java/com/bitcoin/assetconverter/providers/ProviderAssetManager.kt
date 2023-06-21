package com.bitcoin.assetconverter.providers

import android.content.Context
import com.bitcoin.assetconverter.models.ProviderAssets
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class ProviderAssetManager{

    val assets: MutableMap<ProviderType, List<ProviderAssets.Assets>> = mutableMapOf()
    private var initialized = false

    @OptIn(ExperimentalSerializationApi::class)
    fun initialize(context: Context){
        val json = Json { ignoreUnknownKeys = true }
        ProviderType.values().forEach {
            val assetManager = context.assets
            assetManager.open(it.resource).use { inputStream ->
                val assetMapping: ProviderAssets = json.decodeFromStream(inputStream)
                assets[it] = assetMapping.assets
            }
        }
        initialized = true
    }

    fun getAssets(provider: ProviderType): List<ProviderAssets.Assets>{
        if (!initialized){
            throw java.lang.Exception("Please call initialize first")
        }
        return assets[provider] ?: listOf()
    }

}