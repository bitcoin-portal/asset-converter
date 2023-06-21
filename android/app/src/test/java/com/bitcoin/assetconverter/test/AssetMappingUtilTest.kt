package com.bitcoin.assetconverter.test

import com.bitcoin.assetconverter.AssetMappingUtil
import com.bitcoin.assetconverter.mappings.BanxaAssetMapping
import com.bitcoin.assetconverter.mappings.MoonpayAssetMapping
import com.bitcoin.assetconverter.mappings.SimplexAssetMapping
import org.junit.Assert.*
import org.junit.Test


class AssetMappingUtilTest: BaseTest() {

    @Test
    fun testSimplexAssetMapping() {
        val mapping = AssetMappingUtil.getBuyAssets<SimplexAssetMapping>(context)
        assertFalse(mapping?.assets.isNullOrEmpty())
    }

    @Test
    fun testMoonpayAssetMapping() {
        val mapping = AssetMappingUtil.getBuyAssets<MoonpayAssetMapping>(context)
        assertFalse(mapping?.assets.isNullOrEmpty())
    }

    @Test
    fun testBanxasAssetMapping() {
        val mapping = AssetMappingUtil.getBuyAssets<BanxaAssetMapping>(context)
        assertFalse(mapping?.assets.isNullOrEmpty())
    }

    companion object {
        const val BANXAS = "banxa.json"
        const val MOONPAY = "moonpay.json"
        const val SIMPLEX = "simplex.json"
    }

}