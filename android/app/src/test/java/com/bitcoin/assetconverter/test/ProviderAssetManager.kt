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

}