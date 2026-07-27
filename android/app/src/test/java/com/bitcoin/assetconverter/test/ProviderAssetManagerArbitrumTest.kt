package com.bitcoin.assetconverter.test

import com.bitcoin.assetconverter.providers.ProviderAssetManager
import com.bitcoin.assetconverter.providers.ProviderType
import org.junit.Assert.assertEquals
import org.junit.Test

class ProviderAssetManagerArbitrumTest : BaseTest() {

    @Test
    fun moonpayArbitrumUsesAndroidAssetOverride() {
        val assetManager = ProviderAssetManager(context)
        val asset = assetManager.getAssets(ProviderType.MOONPAY)
            .first { it.providerKey == "ETH_ARBITRUM" }

        assertEquals("ARBITRUM", asset.assetId)
        assertEquals("ARB1_BLOCKCHAIN", asset.blockchain)
        assertEquals("ARB1_PROTOCOL", asset.assetProtocol)
    }

    @Test
    fun onramperArbitrumUsesAndroidAssetOverride() {
        val assetManager = ProviderAssetManager(context)
        val asset = assetManager.getAssets(ProviderType.ONRAMPER)
            .first { it.providerKey == "eth_arbitrum" }

        assertEquals("ARBITRUM", asset.assetId)
        assertEquals("ARB1_BLOCKCHAIN", asset.blockchain)
        assertEquals("ARB1_PROTOCOL", asset.assetProtocol)
    }

    @Test
    fun moonpayAssetWithoutAndroidOverrideUsesAssetId() {
        val assetManager = ProviderAssetManager(context)
        val asset = assetManager.getAssets(ProviderType.MOONPAY)
            .first { it.providerKey == "ETH_BASE" }

        assertEquals("ETH", asset.assetId)
        assertEquals("BASE_BLOCKCHAIN", asset.blockchain)
        assertEquals("ETH_PROTOCOL", asset.assetProtocol)
    }
}
