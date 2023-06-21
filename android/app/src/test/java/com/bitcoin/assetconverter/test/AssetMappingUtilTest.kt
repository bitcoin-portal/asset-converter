package com.bitcoin.assetconverter.test

import android.app.Application
import android.content.Context
import android.os.Build
import com.bitcoin.assetconverter.AssetMappingUtil
import com.bitcoin.assetconverter.mappings.BanxaAssetMapping
import com.bitcoin.assetconverter.mappings.MoonpayAssetMapping
import com.bitcoin.assetconverter.mappings.SimplexAssetMapping
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

@RunWith(RobolectricTestRunner::class)
@Config(
    application = AssetMappingUtilTest.ApplicationStub::class,
    manifest = Config.NONE,
    sdk = [Build.VERSION_CODES.O_MR1]
)
class AssetMappingUtilTest {
    internal class ApplicationStub : Application()

    val context: Context = mockk(relaxed = true)

    init {
        every { context.assets.open(BANXAS) } returns readAssetJson(BANXAS)
        every { context.assets.open(MOONPAY) } returns readAssetJson(MOONPAY)
        every { context.assets.open(SIMPLEX) } returns readAssetJson(SIMPLEX)
    }

    private fun readAssetJson(filename: String): InputStream {
        val inputStream = Files.newInputStream(Paths.get("../../buyassets/$filename"))
        if (inputStream == null) {
            throw java.lang.Exception("Invalid Stream")
        } else {
            return inputStream
        }
    }

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