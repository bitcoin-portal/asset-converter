//
//  AssetConvertersTests.swift
//
//
//  Created by Nhat Dinh on 2023/05/15.
//

import XCTest

@testable import AssetConverters

final class AssetConvertersTests: XCTestCase {
    let sut = AssetConverterInteractor()

    func testCanGetAssetList() {
        XCTAssertFalse(sut.getAssetList(provider: .banxa).isEmpty)
        XCTAssertFalse(sut.getAssetList(provider: .moonpay).isEmpty)
        XCTAssertFalse(sut.getAssetList(provider: .simplex).isEmpty)
    }

    func testCanConvertProviderAssetToAssetIdV2() {
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "VERSE-ETH", provider: .banxa), "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "VERSE-ETH", provider: .moonpay), nil)
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "VERSE", provider: .moonpay), "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "VERSE-ETH", provider: .simplex), nil)
    }

    func testCanConvertBaseProviderAssetToAssetIdV2() {
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "ETH-BASE", provider: .banxa), "BASE-ETH-ETH")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "USDC-BASE", provider: .banxa), "BASE-ERC20-0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "ETH_BASE", provider: .moonpay), "BASE-ETH-ETH")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "USDC_BASE", provider: .moonpay), "BASE-ERC20-0x833589fCD6eDb6E08f4c7C32D4f71b54bdA02913")
    }

    func testCanConvertAssetIdV2ToProviderAsset() {
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18", provider: .banxa), "VERSE-ETH")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18", provider: .moonpay), "VERSE")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18", provider: .simplex), nil)

        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "eth-erc20-0x249ca82617ec3dfb2589c4c17ab7ec9765350a18", provider: .banxa), "VERSE-ETH")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "eth-erc20-0x249ca82617ec3dfb2589c4c17ab7ec9765350a18", provider: .moonpay), "VERSE")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "eth-erc20-0x249ca82617ec3dfb2589c4c17ab7ec9765350a18", provider: .simplex), nil)
    }

    func testCanConvertBaseAssetIdV2ToProviderAsset() {
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "BASE-ETH-ETH", provider: .banxa), "ETH-BASE")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "BASE-ETH-ETH", provider: .moonpay), "ETH_BASE")
    }

    func testCanConvertArbitrumProviderAssetToAssetIdV2() {
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "ETH_ARBITRUM", provider: .moonpay), "ARB1-ETH-ETH")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "eth_arbitrum", provider: .onramper), "ARB1-ETH-ETH")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "USDC_ARBITRUM", provider: .moonpay), "ARB1-ERC20-0xaf88d065e77c8cC2239327C5EDb3A432268e5831")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "usdc_arbitrum", provider: .onramper), "ARB1-ERC20-0xaf88d065e77c8cC2239327C5EDb3A432268e5831")
    }

    func testCanConvertArbitrumAssetIdV2ToProviderAsset() {
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ARB1-ETH-ETH", provider: .moonpay), "ETH_ARBITRUM")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ARB1-ETH-ETH", provider: .onramper), "eth_arbitrum")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ARB1-ERC20-0xaf88d065e77c8cC2239327C5EDb3A432268e5831", provider: .moonpay), "USDC_ARBITRUM")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ARB1-ERC20-0xaf88d065e77c8cC2239327C5EDb3A432268e5831", provider: .onramper), "usdc_arbitrum")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "arb1-erc20-0xaf88d065e77c8cc2239327c5edb3a432268e5831", provider: .moonpay), "USDC_ARBITRUM")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "arb1-erc20-0xaf88d065e77c8cc2239327c5edb3a432268e5831", provider: .onramper), "usdc_arbitrum")
    }

    // Onramper's ID for native TRON is `trx_tron`, not `trx` (MTDB-26637). The wallet feeds this
    // value straight into the widget's `defaultCrypto`, `onlyCryptos` and `wallets=<id>:<addr>`
    // params, so a wrong ID leaves the widget with nothing selectable at all.
    func testCanConvertTronProviderAssetToAssetIdV2() {
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "trx_tron", provider: .onramper), "TRX-TRX-TRX")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "usdt_tron", provider: .onramper), "TRX-TRC20-TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t")
        XCTAssertEqual(sut.convertProviderAssetToAssetIdV2(asset: "TRX", provider: .moonpay), "TRX-TRX-TRX")
    }

    func testCanConvertTronAssetIdV2ToProviderAsset() {
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "TRX-TRX-TRX", provider: .onramper), "trx_tron")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "TRX-TRC20-TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t", provider: .onramper), "usdt_tron")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "TRX-TRX-TRX", provider: .moonpay), "TRX")
    }
}
