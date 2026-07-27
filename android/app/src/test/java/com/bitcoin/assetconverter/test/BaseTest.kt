package com.bitcoin.assetconverter.test

import android.content.Context
import io.mockk.every
import io.mockk.mockk
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

open class BaseTest {
    val context: Context = mockk(relaxed = true)

    init {
        every { context.assets.open(AssetMappingUtilTest.BANXAS) } answers { readAssetJson(
            AssetMappingUtilTest.BANXAS
        )}
        every { context.assets.open(AssetMappingUtilTest.MOONPAY) }  answers { readAssetJson(
            AssetMappingUtilTest.MOONPAY
        ) }
        every { context.assets.open(AssetMappingUtilTest.SIMPLEX) }  answers { readAssetJson(
            AssetMappingUtilTest.SIMPLEX
        ) }
        every { context.assets.open(AssetMappingUtilTest.ONRAMPER) }  answers { readAssetJson(
            AssetMappingUtilTest.ONRAMPER
        ) }
    }

    private fun readAssetJson(filename: String): InputStream {
        val inputStream = Files.newInputStream(Paths.get("../../buyassets/$filename"))
        if (inputStream == null) {
            throw java.lang.Exception("Invalid Stream")
        } else {
            return inputStream
        }
    }
}
