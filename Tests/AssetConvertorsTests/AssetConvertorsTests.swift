//
//  AssetConvertersTests.swift
//
//
//  Created by Nhat Dinh on 2023/05/15.
//

import XCTest

@testable import AssetConvertors

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

    func testCanConvertAssetIdV2ToProviderAsset() {
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18", provider: .banxa), "VERSE-ETH")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18", provider: .moonpay), "VERSE")
        XCTAssertEqual(sut.convertAssetIdV2ToProviderAsset(assetIdV2: "ETH-ERC20-0x249cA82617eC3DfB2589c4c17ab7EC9765350a18", provider: .simplex), nil)
    }
}
