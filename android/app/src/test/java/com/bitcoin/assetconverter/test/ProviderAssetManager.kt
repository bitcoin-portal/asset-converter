package com.bitcoin.assetconverter.test

import com.bitcoin.assetconverter.AssetMappingUtil
import com.bitcoin.assetconverter.mappings.BanxaAssetMapping
import com.bitcoin.assetconverter.mappings.MoonpayAssetMapping
import com.bitcoin.assetconverter.mappings.SimplexAssetMapping
import com.bitcoin.assetconverter.providers.ProviderAssetManager
import com.bitcoin.assetconverter.providers.ProviderType
import org.junit.Assert
import org.junit.Test

class ProviderAssetManager: BaseTest() {

    @Test
    fun testProviderAssetManagerBanxas(){
        val legacyMapping = AssetMappingUtil.getBuyAssets<BanxaAssetMapping>(context)
        val assetManager = ProviderAssetManager(context)
        val banxaAsset = assetManager.getAssets(ProviderType.BANXAS)
        Assert.assertEquals(legacyMapping?.assets?.size ?: 0, banxaAsset.size)
    }

    @Test
    fun testProviderAssetManagerMoonpay(){
        val legacyMapping = AssetMappingUtil.getBuyAssets<MoonpayAssetMapping>(context)
        val assetManager = ProviderAssetManager(context)
        val moonpayAssets = assetManager.getAssets(ProviderType.MOONPAY)
        Assert.assertEquals(legacyMapping?.assets?.size ?: 0, moonpayAssets.size)

    }

    @Test
    fun testProviderAssetManagerSimplex(){
        val legacyMapping = AssetMappingUtil.getBuyAssets<SimplexAssetMapping>(context)
        val assetManager = ProviderAssetManager(context)
        val simplexAssets = assetManager.getAssets(ProviderType.SIMPLEX)
        Assert.assertEquals(legacyMapping?.assets?.size ?: 0, simplexAssets.size)

    }

    // Onramper has no legacy AssetMapping to compare against, so assert the file parses
    // into a non-empty list instead. loadAssets() swallows every exception and returns
    // emptyList(), so a malformed onramper.json would otherwise fail silently.
    @Test
    fun testProviderAssetManagerOnramper(){
        val assetManager = ProviderAssetManager(context)
        val onramperAssets = assetManager.getAssets(ProviderType.ONRAMPER)
        Assert.assertFalse(onramperAssets.isEmpty())
    }

    // The android_blockchain / android_asset_protocol values are what the wallet maps onto
    // its own enums, so pin them for the Arbitrum tokens on both providers.
    @Test
    fun testArbitrumTokensExposeAndroidKeys(){
        val assetManager = ProviderAssetManager(context)

        val expected = mapOf(
            ProviderType.MOONPAY to listOf(
                "USDT_ARBITRUM" to USDT_ARBITRUM,
                "USDC_ARBITRUM" to USDC_ARBITRUM
            ),
            ProviderType.ONRAMPER to listOf(
                "usdt_arbitrum" to USDT_ARBITRUM,
                "usdc_arbitrum" to USDC_ARBITRUM,
                "wbtc_arbitrum" to WBTC_ARBITRUM
            )
        )

        expected.forEach { (provider, entries) ->
            val assets = assetManager.getAssets(provider).associateBy { it.providerKey }
            entries.forEach { (providerKey, assetId) ->
                val asset = assets[providerKey]
                Assert.assertNotNull("$provider is missing $providerKey", asset)
                Assert.assertEquals(assetId, asset?.assetId)
                Assert.assertEquals("ARB1_BLOCKCHAIN", asset?.blockchain)
                Assert.assertEquals("ERC_20_PROTOCOL", asset?.assetProtocol)
            }
        }
    }

    // WBTC is Onramper-only: MoonPay lists no WBTC on any network.
    @Test
    fun testMoonpayHasNoArbitrumWbtc(){
        val assetManager = ProviderAssetManager(context)
        val moonpayKeys = assetManager.getAssets(ProviderType.MOONPAY).map { it.providerKey }
        Assert.assertFalse(moonpayKeys.contains("WBTC_ARBITRUM"))
    }

    companion object {
        const val USDC_ARBITRUM = "0xaf88d065e77c8cC2239327C5EDb3A432268e5831"
        const val USDT_ARBITRUM = "0xFd086bC7CD5C481DCC9C85ebE478A1C0b69FCbb9"
        const val WBTC_ARBITRUM = "0x2f2a2543B76A4166549F7aaB2e75Bef0aefC5B0f"
    }

}