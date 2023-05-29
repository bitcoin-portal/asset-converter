// swift-tools-version: 5.6
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "AssetConvertors",
    platforms: [
        .iOS(.v15),
        .tvOS(.v9),
        .macOS(.v10_10),
        .watchOS(.v3),
    ],
    products: [
        // Products define the executables and libraries a package produces, and make them visible to other packages.
        .library(
            name: "AssetConvertors",
            targets: ["AssetConvertors"])
    ],
    dependencies: [
        // Dependencies declare other packages that this package depends on.
    ],
    targets: [
        // Targets are the basic building blocks of a package. A target can define a module or a test suite.
        // Targets can depend on other targets in this package, and on products in packages this package depends on.
        .target(
            name: "AssetConvertors",
            dependencies: [],
            path: "ios/",
            // exclude: ["android"],
            resources: [
                .process("Resources/buyassets")
            ]
        ),
        .testTarget(
            name: "AssetConvertorsTests",
            dependencies: ["AssetConvertors"]),
    ]
)
