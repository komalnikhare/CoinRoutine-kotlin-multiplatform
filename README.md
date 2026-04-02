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

### 🎨 User Interface
- **Modern UI**: Clean, responsive interface built with Compose Multiplatform
- **Material Design 3**: Following latest Material Design guidelines
- **Color Coding**: Green for profits, red for losses
- **Loading States**: Proper loading indicators and error handling
- **Responsive Design**: Adapts to different screen sizes and orientations

### 🏗️ Architecture & Development
- **Cross-Platform**: Single codebase targeting both Android and iOS
- **MVVM Architecture**: Clean separation of UI and business logic
- **Clean Architecture**: Well-structured layers with clear separation of concerns
- **Dependency Injection**: Koin for modular dependency management
- **Local Database**: Room database with SQLite for offline data persistence

### 🔄 Data Management
- **Network Operations**: HTTP client for API calls with Ktor
- **Local Storage**: Room database for portfolio and balance data
- **Data Mapping**: Clean transformation between DTOs and domain models
- **Error Handling**: Comprehensive error management and user feedback

## 🏗️ Architecture

The project follows Clean Architecture with clear separation of layers:

```
├── Presentation Layer
│   ├── CoinsListScreen (UI)
│   ├── CoinsListViewModel (MVVM)
│   └── UI Components (PerformanceChart)
├── Domain Layer
│   ├── Use Cases (GetCoinsListUseCase, GetCoinPriceHistoryUseCase)
│   ├── Models (CoinModel, PriceModel)
│   └── Repository Interfaces
├── Data Layer
│   ├── Remote Data Source (KtorCoinsRemoteDataSource)
│   ├── Local Database (Room Database)
│   ├── DAOs (PortfolioDao, UserBalanceDao)
│   ├── Entities (PortfolioCoinEntity, UserBalanceEntity)
│   ├── DTOs (Data Transfer Objects)
│   └── Mappers
└── Core Layer
    ├── Network (HttpClientFactory)
    ├── Database (PortfolioDatabaseFactory)
    ├── Domain Models (Result, Error handling)
    └── Utilities (Formatting, Logging)
```

## 🛠️ Technology Stack

### Core Technologies
- **Kotlin Multiplatform**: Cross-platform development
- **Compose Multiplatform 1.7.0**: Modern declarative UI framework
- **Kotlin 2.0.21**: Programming language with Coroutines support

### Architecture & DI
- **Koin 4.0.0**: Dependency injection framework
- **MVVM Pattern**: Model-View-ViewModel architecture
- **Clean Architecture**: Separation of concerns

### Networking & Data
- **Ktor 3.0.0**: HTTP client for network operations
- **Kotlinx Serialization 1.7.3**: JSON serialization/deserialization
- **Room Database 2.7.0-alpha10**: Local SQLite database with KMP support
- **SQLite Driver**: Bundled SQLite driver for cross-platform database access
- **Coil 3.0.0**: Image loading library

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
- **Android**: Target SDK 35, Min SDK 24
- **iOS**: Native iOS app with Compose Multiplatform

## 📦 Key Components

### Presentation Layer
- **CoinsListScreen**: Main screen displaying cryptocurrency list
- **CoinsListViewModel**: Manages UI state and business logic
- **PerformanceChart**: Custom canvas-based chart component
- **UiCoinListItem**: UI model for coin list items

### Domain Layer
- **GetCoinsListUseCase**: Fetches cryptocurrency list
- **GetCoinPriceHistoryUseCase**: Retrieves price history for charts
- **Result<T>**: Generic wrapper for API responses
- **CoinModel/PriceModel**: Domain models

### Data Layer
- **KtorCoinsRemoteDataSource**: HTTP client implementation
- **PortfolioDatabase**: Room database for local persistence
- **PortfolioDao**: Data access object for portfolio coins
- **UserBalanceDao**: Data access object for user cash balance
- **PortfolioCoinEntity**: Entity for storing coin holdings
- **UserBalanceEntity**: Entity for storing cash balance
- **CoinItemMapper**: Maps DTOs to domain models
- **DTOs**: Data transfer objects for API responses

### Database Layer
- **PortfolioDatabaseFactory**: Factory for creating database instances
- **PortfolioDatabaseCreator**: Platform-specific database constructor
- **getPortfolioDatabaseBuilder**: Platform-specific database builder

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
│       │   ├── portfolio/              # Portfolio feature module
│       │   │   ├── data/local/         # Local database layer
│       │   │   │   ├── PortfolioDao.kt
│       │   │   │   ├── UserBalanceDao.kt
│       │   │   │   ├── PortfolioCoinEntity.kt
│       │   │   │   └── UserBalanceEntity.kt
│       │   │   ├── data/              # Data layer
│       │   │   ├── domain/            # Domain layer
│       │   │   └── presentation/      # UI layer
│       │   ├── core/                  # Core utilities
│       │   │   └── database/          # Database configuration
│       │   │       └── portfolio/     # Portfolio database
│       │   │           ├── PortfolioDatabase.kt
│       │   │           └── PortfolioDatabaseFactory.kt
│       │   ├── di/                    # Dependency injection
│       │   └── theme/                 # UI theme
│       ├── androidMain/kotlin/         # Android-specific
│       │   └── core/database/         # Android database builder
│       └── iosMain/kotlin/            # iOS-specific
│           └── core/database/         # iOS database builder
├── iosApp/                             # iOS app entry point
├── gradle/                             # Gradle configuration
└── build.gradle.kts                    # Root build configuration
```

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
- **Coin List Screen**: Main screen displaying top cryptocurrencies with real-time data
- **Portfolio Dashboard**: Comprehensive view of user's cryptocurrency holdings and cash balance
- **Interactive Charts**: Custom canvas-based 24-hour price history visualization
- **Responsive Layout**: Optimized for both phones and tablets

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

1. **CoinsListViewModel** requests data via use cases
2. **Use cases** interact with repository interfaces
3. **KtorCoinsRemoteDataSource** makes HTTP requests to crypto API
4. **PortfolioDatabase** handles local data persistence via Room
5. **Data is mapped** from DTOs to domain models
6. **UI state updates** flow back to the Compose UI
7. **User interactions** trigger view model actions
8. **Local database** stores portfolio holdings and cash balance

## 🧪 Testing

The project includes comprehensive testing setup:
- **Unit Tests**: Test business logic, use cases, and data transformations
- **Flow Testing**: Turbine library for testing Kotlin Flow operations
- **UI Testing**: Compose UI testing for component verification
- **Database Testing**: Room database testing with in-memory SQLite
- **Mock Implementations**: Test doubles for external dependencies
- **Integration Tests**: End-to-end testing of critical user flows

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
- [ ] Price alerts and notifications
- [ ] Advanced charting features
- [ ] User authentication
- [ ] Portfolio performance analytics
- [ ] Transaction history tracking
- [ ] Additional cryptocurrency exchanges

## 📄 License

This project is open source and available under the MIT License.

---

Built with ❤️ using Kotlin Multiplatform and Compose Multiplatform
