## How to add or remove assets

Steps:

- make changes (add / delete) on buyassets' json files.
- run this command to reflect the changes on iOS assets resource.

```
sh scripts/copy-resource.sh
```
- create PR with changes. should include changes for buyassets and ios/Resources/buyassets
- bump up version to match next tag in [build.gradle](https://github.com/bitcoin-portal/asset-converter/blob/trunk/android/app/build.gradle#L8)

## Moonpay, Simplex, Banxa buyable assets

### Moonpay

```
AAVE - Aave
ADA - Cardano
ALGO - Algorand
APE - ApeCoin (ERC-20)
APT - Aptos
ATOM - Cosmos
AVA - Travala
AVAX_CCHAIN - Avalanche (C-Chain)
AXS - Axie Infinity
BAT - Basic Attention Token
BCH - Bitcoin Cash
BNB - Binance Coin (BEP-2)
BNB_BSC - Binance Coin (BEP-20)
BTC - Bitcoin
BTTC - BitTorrent Token
BUSD - Binance USD (BEP-2)
BUSD_BSC - Binance USD (BEP-20)
CELO - Celo
CHZ - Chiliz
COMP - Compound
CUSD - Celo Dollar
DAI - Dai
DAI_PALM - DAI (palm)
DAI_ZKSYNC - Dai (zkSync)
DGB - DigiByte
DOGE - Dogecoin
DOT - Polkadot
EGLD - MultiversX (Elrond)
ENJ - Enjin Coin
EOS - EOS
ETC - Ethereum Classic
ETH - Ethereum
ETH_ARBITRUM - Ethereum (Arbitrum)
ETH_OPTIMISM - Ethereum (Optimism)
ETH_POLYGON - Ethereum (Polygon)
ETH_ZKSYNC - Ethereum (zkSync)
EURL - Lugh (ERC-20)
EURL_TEZOS - Lugh (Tezos)
FIL - Filecoin
FLOW - Flow
GODS_IMMUTABLE - Gods Unchained (Immutable)
HBAR - Hedera Hashgraph
IMX - Immutable X (ERC-20)
IMX_IMMUTABLE - Immutable X (Immutable)
KAVA - Kava
KEY - SelfKey
KLAY - Klaytn
LINK - Chainlink
LOOKS - LooksRare
LSK - Lisk
LTC - Litecoin
MAGIC_ARBITRUM - Magic (Arbitrum)
MANA - Decentraland
MATIC - Polygon (ERC-20)
MATIC_POLYGON - Polygon (Polygon)
MIOTA - IOTA
MKR - Maker
MOB - MobileCoin
NEAR - NEAR Protocol
NIM - Nimiq
OKB - OKB
OKT - OKT
OM - MANTRA DAO
OMG - OMG Network
ORN - Orion (ERC-20)
QTUM - Qtum
RFUEL - Rio DeFi
RONIN - Ronin
RUNE - THORChain
RVN - Ravencoin
SAND - The Sandbox (ERC-20)
SHIB - Shiba Inu (ERC-20)
SLP - Smooth Love Potion (ERC-20)
SLP_RONIN - Smooth Love Potion (Ronin)
SNX - Synthetix
SOL - Solana
SRM - Serum
STMX - StormX
STX - Stacks
SUI - Sui
SWEAT_NEAR - Sweat (Near)
TOMO - TomoChain
TON - Toncoin
TRX - TRON
TUSD - TrueUSD
UNI - Uniswap
USDC - USD Coin (ERC-20)
USDC_APTOS - USD Coin (Aptos)
USDC_ARBITRUM - USD Coin (Arbitrum)
USDC_FLOW - USD Coin (Flow)
USDC_OPTIMISM - USD Coin (Optimism)
USDC_POLYGON - USD Coin (Polygon)
USDC_RONIN - USD Coin (Ronin)
USDC_SOL - USD Coin (Solana)
USDC_XLM - USD Coin (Stellar)
USDC_ZKSYNC - USD Coin (zkSync)
USDT - Tether (ERC-20)
USDT_POLYGON - Tether (Polygon)
USDT_TRX - Tether (TRC-20)
USDT_ZKSYNC - Tether (zkSync)
UTK - Utrust
VERSE - Verse (ERC-20)
VET - VeChain
VOXEL_POLYGON - Voxies (Polygon)
WAXP - WAX
WBTC - Wrapped Bitcoin
WETH - Wrapped Ether (ERC-20)
XEM - NEM
XLM - Stellar
XNO - Nano
XRP - XRP
XTZ - Tezos
ZIL - Zilliqa
ZRX - 0x
```

### Simplex

```
 { code: "AVAX-C", type: "crypto" },
  { code: "BCH", type: "crypto" },
  { code: "BNB", type: "crypto" },
  { code: "BTC", type: "crypto" },
  { code: "DOGE", type: "crypto" },
  { code: "DOT", type: "crypto" },
  { code: "ETH", type: "crypto" },
  { code: "LTC", type: "crypto" },
  { code: "MATIC", type: "crypto" },
  { code: "SUSHI", type: "crypto" },
  { code: "USDC", type: "crypto" },
  { code: "USDT", type: "crypto" },
  { code: "XLM", type: "crypto" },
  { code: "XRP", type: "crypto" },
```


### Banxa

Fetch via Banxa provided API: https://docs.banxa.com/reference/get-crypto-currencies
