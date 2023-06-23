package com.bitcoin.assetconverter.test

import android.app.Application
import android.content.Context
import android.os.Build
import io.mockk.every
import io.mockk.mockk
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

@RunWith(RobolectricTestRunner::class)
@Config(
    application = BaseTest.ApplicationStub::class,
    manifest = Config.NONE,
    sdk = [Build.VERSION_CODES.O_MR1]
)
open class BaseTest {
    internal class ApplicationStub : Application()

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