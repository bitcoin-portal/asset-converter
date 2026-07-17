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
    }

    func testCanConvertArbitrumAssetIdV2ToProviderAsset() {
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ARB1-ETH-ETH", provider: .moonpay), "ETH_ARBITRUM")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ARB1-ETH-ETH", provider: .onramper), "eth_arbitrum")
    }
}
