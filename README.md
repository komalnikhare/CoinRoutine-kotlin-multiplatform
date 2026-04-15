# CoinRoutine 🪙

A modern **Kotlin Multiplatform** cryptocurrency tracking application built with **Compose Multiplatform**, targeting Android and iOS platforms.

## 📱 Overview

CoinRoutine is a comprehensive cryptocurrency portfolio management application that provides real-time coin prices, 24-hour price changes, interactive price charts, and local portfolio tracking. The app combines powerful market data visualization with robust portfolio management capabilities, all built with Clean Architecture principles for maintainable and scalable code. Users can track their cryptocurrency investments, monitor cash balances, and access market data seamlessly across Android and iOS platforms.

## 🌟 Key Highlights

- **All-in-One Solution**: Combines market data tracking with portfolio management in a single app
- **Cross-Platform Excellence**: Native performance on both Android and iOS from a single codebase
- **Offline-First Design**: Local database ensures portfolio data is always accessible
- **Modern Architecture**: Clean Architecture and MVVM patterns for maintainable code
- **Rich User Experience**: Smooth animations, intuitive navigation, and responsive design

## ✨ Features

### 📊 Cryptocurrency Tracking
- **Real-time Cryptocurrency Data**: View top cryptocurrencies with current prices and 24-hour changes
- **Interactive Price Charts**: Long-press any coin to view 24-hour price history with custom performance charts
- **Price Formatting**: Properly formatted prices and percentage changes with color coding
- **Market Data**: Access to comprehensive cryptocurrency market information

### 💼 Portfolio Management
- **Portfolio Tracking**: Track cryptocurrency holdings with local persistence
- **User Balance Management**: Monitor and update cash balance with Room database storage
- **Local Data Persistence**: Offline storage using Room database with SQLite
- **Cross-Platform Data Sync**: Consistent data across Android and iOS platforms
- **Real-time Portfolio Valuation**: Calculate current value based on live market prices
- **Holdings Overview**: View detailed information about owned cryptocurrencies

### 🎨 User Interface
- **Modern UI**: Clean, responsive interface built with Compose Multiplatform
- **Material Design 3**: Following latest Material Design guidelines
- **Color Coding**: Green for profits, red for losses
- **Loading States**: Proper loading indicators and error handling
- **Responsive Design**: Adapts to different screen sizes and orientations
- **Currency Formatting**: Automatic fiat currency formatting with proper decimal placement
- **Input Validation**: Real-time validation for buy/sell amounts
- **Visual Transformations**: Enhanced text input with currency symbols and formatting

### 🏗️ Architecture & Development
- **Cross-Platform**: Single codebase targeting both Android and iOS
- **MVVM Architecture**: Clean separation of UI and business logic
- **Clean Architecture**: Well-structured layers with clear separation of concerns
- **Dependency Injection**: Koin for modular dependency management
- **Local Database**: Room database with SQLite for offline data persistence
- **Navigation**: Type-safe navigation with Compose Navigation and Kotlinx Serialization

### 🔄 Data Management
- **Network Operations**: HTTP client for API calls with Ktor
- **Local Storage**: Room database for portfolio and balance data
- **Data Mapping**: Clean transformation between DTOs and domain models
- **Error Handling**: Comprehensive error management and user feedback

### 💰 Trading Features
- **Buy Cryptocurrency**: Purchase coins using available cash balance
- **Sell Cryptocurrency**: Sell owned coins and add proceeds to cash balance
- **Real-time Price Integration**: Buy/sell at current market prices
- **Transaction Validation**: Ensure sufficient funds and holdings
- **Portfolio Updates**: Automatic portfolio updates after trades
- **Currency Input**: Custom currency formatting for buy/sell amounts
- **Trade History**: Track all buy/sell transactions locally

## 🏗️ Architecture

The project follows Clean Architecture with clear separation of layers:

```
├── Presentation Layer
│   ├── CoinsListScreen (Market Discovery)
│   ├── PortfolioScreen (Portfolio Overview)
│   ├── BuyScreen (Purchase Coins)
│   ├── SellScreen (Sell Coins)
│   ├── ViewModels (MVVM Pattern)
│   └── UI Components (PerformanceChart, Currency Input)
├── Domain Layer
│   ├── Use Cases
│   │   ├── GetCoinsListUseCase
│   │   ├── GetCoinPriceHistoryUseCase
│   │   ├── GetCoinDetailsUseCase
│   │   ├── BuyCoinUseCase
│   │   └── SellCoinUseCase
│   ├── Models (CoinModel, PriceModel, PortfolioCoinModel)
│   └── Repository Interfaces
├── Data Layer
│   ├── Remote Data Source (KtorCoinsRemoteDataSource)
│   ├── Local Database (Room Database)
│   ├── DAOs (PortfolioDao, UserBalanceDao)
│   ├── Entities (PortfolioCoinEntity, UserBalanceEntity)
│   ├── DTOs (Data Transfer Objects)
│   └── Mappers (CoinItemMapper, PortfolioEntityMapper)
└── Core Layer
    ├── Network (HttpClientFactory)
    ├── Database (PortfolioDatabaseFactory)
    ├── Navigation (Type-safe Navigation)
    ├── Domain Models (Result, Error handling)
    └── Utilities (Formatting, Logging, Currency Transformations)
```

## 🛠️ Technology Stack

### Core Technologies
- **Kotlin Multiplatform**: Cross-platform development
- **Compose Multiplatform 1.7.0**: Modern declarative UI framework
- **Kotlin 2.0.21**: Programming language with Coroutines support
- **Kotlinx DateTime 0.6.1**: Date and time utilities

### Architecture & DI
- **Koin 4.0.0**: Dependency injection framework
- **MVVM Pattern**: Model-View-ViewModel architecture
- **Clean Architecture**: Separation of concerns
- **KSP 2.0.21-1.0.25**: Kotlin Symbol Processing for annotation processing

### Networking & Data
- **Ktor 3.0.0**: HTTP client for network operations
- **Kotlinx Serialization 1.7.3**: JSON serialization/deserialization
- **Room Database 2.7.0-alpha11**: Local SQLite database with KMP support
- **SQLite 2.5.0-SNAPSHOT**: Bundled SQLite driver for cross-platform database access
- **Coil 3.0.0**: Image loading library with SVG support

### UI & Graphics
- **Material Design 3**: Modern design system
- **Custom Canvas API**: For performance chart rendering
- **Experimental Foundation APIs**: Combined clickable gestures

### Testing
- **Kotlin Test**: Unit testing framework
- **Turbine**: Flow testing utilities
- **AssertK**: Assertion library
- **Compose UI Testing**: UI component testing

### Platform-Specific
- **Android**: Target SDK 35, Min SDK 24, AGP 8.5.2
- **iOS**: Native iOS app with Compose Multiplatform
- **Biometric Support**: Android Biometric API 1.4.0-alpha02

## 📦 Key Components

### Presentation Layer
- **CoinsListScreen**: Market discovery screen displaying cryptocurrency list
- **PortfolioScreen**: Portfolio overview showing holdings and cash balance
- **BuyScreen**: Purchase interface for acquiring cryptocurrencies
- **SellScreen**: Selling interface for owned cryptocurrencies
- **ViewModels**: CoinsListViewModel, PortfolioViewModel, BuyViewModel, SellViewModel
- **UI Components**: PerformanceChart, CurrencyVisualTransformation, TradeScreen
- **UI Models**: UiCoinListItem, UiPortfolioCoinItem, UiTradeCoinItem

### Domain Layer
- **Use Cases**: 
  - GetCoinsListUseCase, GetCoinPriceHistoryUseCase, GetCoinDetailsUseCase
  - BuyCoinUseCase, SellCoinUseCase
- **Models**: CoinModel, PriceModel, PortfolioCoinModel
- **Repository**: PortfolioRepository interface
- **Result<T>**: Generic wrapper for API responses

### Data Layer
- **Remote Data Source**: KtorCoinsRemoteDataSource for API calls
- **Repository Implementation**: PortfolioRepositoryImpl
- **Database**: PortfolioDatabase (Room)
- **DAOs**: PortfolioDao, UserBalanceDao
- **Entities**: PortfolioCoinEntity, UserBalanceEntity
- **Mappers**: CoinItemMapper, PortfolioEntityMapper, TradeCoinMapper
- **DTOs**: CoinsResponseDto, CoinDetailsResponseDto, CoinPriceHistoryResponseDto

### Navigation
- **Type-safe Navigation**: Compose Navigation with Kotlinx Serialization
- **Routes**: Portfolio (start), Coins, Buy(coinId), Sell(coinId)
- **Navigation Flow**: Portfolio ↔ Coins → Buy/Sell → Portfolio

### Core Layer
- **Network**: HttpClientFactory with Ktor configuration
- **Database**: PortfolioDatabaseFactory and platform-specific builders
- **Domain Models**: Result, Error, DataError handling
- **Utilities**: Formatter, Logger, DataErrorToString, CurrencyOffsetMapping

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- Xcode 15+ (for iOS development)
- Kotlin Multiplatform Mobile plugin

### Build and Run Android Application
```bash
# on macOS/Linux
./gradlew :composeApp:assembleDebug

# on Windows
.\gradlew.bat :composeApp:assembleDebug
```

### Build and Run iOS Application
Open the `iosApp` directory in Xcode and run it from there, or use the run configuration from your IDE's toolbar.

## 📁 Project Structure

```
CoinRoutine/
├── composeApp/
│   └── src/
│       ├── commonMain/kotlin/          # Shared code
│       │   └── org/example/project/
│       │       ├── App.kt              # Main app entry point
│       │       ├── coins/              # Cryptocurrency market module
│       │       │   ├── data/
│       │       │   │   ├── remote/     # API integration
│       │       │   │   │   ├── dto/    # Data transfer objects
│       │       │   │   │   └── imp/    # Ktor implementation
│       │       │   │   └── mapper/    # Data mapping
│       │       │   ├── domain/
│       │       │   │   ├── api/       # Repository interfaces
│       │       │   │   ├── models/    # Domain models
│       │       │   │   └── usecases/  # Business logic
│       │       │   └── presentation/
│       │       │       ├── components/ # UI components
│       │       │       ├── CoinsListScreen.kt
│       │       │       ├── CoinsListViewModel.kt
│       │       │       └── CoinsState.kt
│       │       ├── portfolio/          # Portfolio management module
│       │       │   ├── data/
│       │       │   │   ├── local/     # Local database
│       │       │   │   │   ├── PortfolioDao.kt
│       │       │   │   │   ├── UserBalanceDao.kt
│       │       │   │   │   ├── PortfolioCoinEntity.kt
│       │       │   │   │   └── UserBalanceEntity.kt
│       │       │   │   ├── mapper/    # Data mapping
│       │       │   │   └── PortfolioRepositoryImpl.kt
│       │       │   ├── domain/
│       │       │   │   ├── PortfolioRepository.kt
│       │       │   │   └── PortfolioCoinModel.kt
│       │       │   └── presentation/
│       │       │       ├── PortfolioScreen.kt
│       │       │       ├── PortfolioViewModel.kt
│       │       │       └── PortfolioState.kt
│       │       ├── trade/               # Trading functionality module
│       │       │   ├── domain/
│       │       │   │   ├── BuyCoinUseCase.kt
│       │       │   │   └── SellCoinUseCase.kt
│       │       │   └── presentation/
│       │       │       ├── buy/       # Buy screen
│       │       │       ├── sell/      # Sell screen
│       │       │       ├── common/    # Shared trade components
│       │       │       │   ├── TradeScreen.kt
│       │       │       │   ├── component/ # Currency formatting
│       │       │       │   └── mapper/   # Trade data mapping
│       │       ├── core/               # Core utilities and shared code
│       │       │   ├── database/
│       │       │   │   └── portfolio/  # Database configuration
│       │       │   ├── domain/        # Core domain models
│       │       │   ├── network/       # HTTP client setup
│       │       │   ├── navigation/    # Type-safe navigation
│       │       │   └── util/          # Utilities and helpers
│       │       ├── di/                 # Dependency injection
│       │       │   └── Module.kt       # Koin DI configuration
│       │       └── theme/              # UI theme and styling
│       ├── androidMain/kotlin/         # Android-specific code
│       │   └── core/database/         # Android database builder
│       ├── iosMain/kotlin/            # iOS-specific code
│       │   └── core/database/         # iOS database builder
│       └── commonTest/kotlin/         # Shared tests
├── iosApp/                             # iOS app entry point
│   ├── iosApp/                        # iOS SwiftUI wrapper
│   └── iosApp.xcodeproj/              # Xcode project
├── gradle/                            # Gradle configuration
│   └── libs.versions.toml             # Version catalog
├── build.gradle.kts                   # Root build configuration
└── settings.gradle.kts                # Gradle settings
```

## 🧭 Navigation & App Flow

The app uses type-safe navigation with Compose Navigation and Kotlinx Serialization for a robust, compile-time safe navigation system.

### Navigation Routes
- **Portfolio** (Start Destination): Main portfolio overview
- **Coins**: Market discovery screen
- **Buy(coinId)**: Purchase screen for specific coin
- **Sell(coinId)**: Selling screen for owned coin

### User Journey
1. **Portfolio Screen** (Start)
   - View current cryptocurrency holdings
   - Check cash balance
   - Click on owned coin → Navigate to Sell
   - Click "Discover Coins" → Navigate to Coins

2. **Coins Screen** (Market Discovery)
   - Browse available cryptocurrencies
   - View real-time prices and charts
   - Click on coin → Navigate to Buy

3. **Buy Screen** (Purchase)
   - Select amount to purchase
   - Validate sufficient cash balance
   - Complete purchase → Navigate back to Portfolio

4. **Sell Screen** (Selling)
   - Select amount to sell
   - Validate sufficient holdings
   - Complete sale → Navigate back to Portfolio

### Navigation Features
- **Type-safe Routes**: Compile-time safety for navigation parameters
- **Nested Navigation**: Clean separation between feature modules
- **State Restoration**: Proper navigation state management
- **Deep Linking**: Support for direct navigation to specific screens

## 🔧 Configuration

The project uses Version Catalogs for dependency management. All dependencies are defined in `gradle/libs.versions.toml`.

### Key Dependencies
- **Compose Multiplatform**: UI framework
- **Ktor**: HTTP client for API calls
- **Koin**: Dependency injection
- **Room Database**: Local SQLite database with KMP support
- **Coil**: Image loading
- **Kotlinx Serialization**: JSON handling
- **SQLite Driver**: Cross-platform SQLite driver

## 🎨 UI Features & User Experience

### Core Interface
- **Portfolio Screen**: Main screen displaying cryptocurrency holdings and cash balance
- **Coin List Screen**: Market discovery screen with real-time cryptocurrency data
- **Buy Screen**: Purchase interface with currency formatting and validation
- **Sell Screen**: Selling interface with holdings management
- **Interactive Charts**: Custom canvas-based 24-hour price history visualization
- **Responsive Layout**: Optimized for both phones and tablets
- **Biometric Support**: Android Biometric API integration for secure access

### Visual Design
- **Material Design 3**: Modern design system with consistent theming
- **Color-Coded Indicators**: Green for positive changes, red for negative
- **Smooth Animations**: Fluid transitions and micro-interactions
- **Loading States**: Elegant loading indicators and skeleton screens

### User Interaction
- **Long-Press Gestures**: Access detailed price charts and additional information
- **Intuitive Navigation**: Easy-to-use navigation patterns
- **Error Handling**: User-friendly error messages and recovery options
- **Accessibility**: Support for screen readers and other accessibility features

## 💾 Database & Data Persistence

### Room Database Implementation
- **Cross-Platform Room**: Utilizing Room Database 2.7.0-alpha10 with Kotlin Multiplatform support
- **SQLite Integration**: Bundled SQLite driver for consistent behavior across platforms
- **Database Versioning**: Proper migration support with version management (currently v2)

### Data Entities
- **PortfolioCoinEntity**: Stores user's cryptocurrency holdings
- **UserBalanceEntity**: Manages cash balance with primary key for single record
- **Entity Relationships**: Well-defined relationships between portfolio and balance data

### Data Access Objects (DAOs)
- **PortfolioDao**: Handles all portfolio-related database operations
- **UserBalanceDao**: Manages cash balance operations (get, insert, update)
- **Suspend Functions**: All database operations are coroutine-safe

### Platform-Specific Implementation
- **Android**: Uses Android's native SQLite implementation
- **iOS**: Leverages iOS SQLite with platform-specific database builder
- **Shared Logic**: Common database operations shared across platforms

## 🔄 Data Flow

### Market Data Flow
1. **CoinsListViewModel** requests data via use cases
2. **Use cases** interact with repository interfaces
3. **KtorCoinsRemoteDataSource** makes HTTP requests to crypto API
4. **Data is mapped** from DTOs to domain models via CoinItemMapper
5. **UI state updates** flow back to the Compose UI

### Portfolio Data Flow
1. **PortfolioViewModel** requests portfolio data
2. **PortfolioRepository** queries local Room database
3. **PortfolioDao/UserBalanceDao** execute database operations
4. **Data is mapped** from entities to domain models
5. **Portfolio state** updates in the UI

### Trading Data Flow
1. **BuyViewModel/SellViewModel** handle trade requests
2. **BuyCoinUseCase/SellCoinUseCase** validate and process trades
3. **PortfolioRepository** updates local database
4. **PortfolioDao/UserBalanceDao** execute transactions
5. **Portfolio state** refreshes with updated holdings
6. **Navigation** returns user to portfolio screen

### Complete User Interaction Flow
1. **User interactions** trigger view model actions
2. **View models** coordinate use cases for business logic
3. **Use cases** interact with repositories for data operations
4. **Repositories** handle both remote (API) and local (database) data
5. **Local database** stores portfolio holdings and cash balance
6. **Remote API** provides real-time market data
7. **UI state** updates reactively across all screens
8. **Navigation** provides seamless screen transitions

## 🧪 Testing

The project includes a comprehensive testing framework:
- **Unit Tests**: Test business logic, use cases, and data transformations
- **Flow Testing**: Turbine 0.7.0 library for testing Kotlin Flow operations
- **UI Testing**: Compose UI testing for component verification
- **Database Testing**: Room database testing with in-memory SQLite
- **Assertion Library**: AssertK 0.25 for fluent assertions
- **Coroutines Testing**: Kotlinx Coroutines Test 1.9.0 for async testing
- **Mock Implementations**: Test doubles for external dependencies
- **Integration Tests**: End-to-end testing of critical user flows

### Test Structure
- **commonTest**: Shared tests for all platforms
- **Test Dependencies**: Configured in libs.versions.toml
- **Test Utilities**: Helper functions and test doubles
- **CI/CD Ready**: Test configurations for continuous integration

## 🛠️ Development & Contribution

### Development Setup
- **IDE Requirements**: Android Studio Hedgehog or later with KMP plugin
- **iOS Development**: Xcode 15+ required for iOS builds
- **Build System**: Gradle with Kotlin DSL
- **Version Control**: Git with conventional commits recommended

### Code Quality
- **Code Style**: Kotlin official style guide
- **Architecture**: Strict adherence to Clean Architecture principles
- **Dependency Management**: Version Catalogs for centralized dependency control
- **Documentation**: Comprehensive README and code documentation

### Contributing Guidelines
1. Follow the existing code style and architecture patterns
2. Add appropriate tests for new features
3. Update documentation for any API changes
4. Ensure cross-platform compatibility
5. Use meaningful commit messages

## 📱 Platform Support

- **Android**: Full support with Material Design 3
- **iOS**: Native iOS app using Compose Multiplatform
- **Shared Logic**: 100% code sharing for business logic, networking, and UI

## 🔮 Future Enhancements

- [x] Portfolio tracking and management
- [x] User balance tracking with local persistence
- [x] Buy/sell cryptocurrency functionality
- [x] Real-time price charts and market data
- [x] Type-safe navigation system
- [x] Currency formatting and input validation
- [x] Cross-platform database with Room
- [ ] Price alerts and notifications
- [ ] Advanced charting features (technical indicators)
- [ ] User authentication and biometric security
- [ ] Portfolio performance analytics and reporting
- [ ] Transaction history tracking and export
- [ ] Additional cryptocurrency exchanges integration
- [ ] Portfolio synchronization across devices
- [ ] Advanced order types (limit, stop-loss)

## 📄 License

This project is open source and available under the MIT License.

---

Built with ❤️ using Kotlin Multiplatform and Compose Multiplatform
