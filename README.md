# CoinRoutine 🪙

A modern **Kotlin Multiplatform** cryptocurrency tracking application built with **Compose Multiplatform**, targeting Android and iOS platforms.

## 📱 Overview

CoinRoutine is a cryptocurrency portfolio tracking app that provides real-time coin prices, 24-hour price changes, and interactive price charts. The app follows Clean Architecture principles with a clean separation of concerns between data, domain, and presentation layers.

## ✨ Features

- **Real-time Cryptocurrency Data**: View top cryptocurrencies with current prices and 24-hour changes
- **Interactive Price Charts**: Long-press any coin to view 24-hour price history with custom performance charts
- **Modern UI**: Clean, responsive interface built with Compose Multiplatform
- **Cross-Platform**: Single codebase targeting both Android and iOS
- **MVVM Architecture**: Clean separation of UI and business logic
- **Dependency Injection**: Koin for modular dependency management

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
│   ├── DTOs (Data Transfer Objects)
│   └── Mappers
└── Core Layer
    ├── Network (HttpClientFactory)
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
- **CoinItemMapper**: Maps DTOs to domain models
- **DTOs**: Data transfer objects for API responses

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
│       │   ├── coins/                  # Feature module
│       │   │   ├── data/              # Data layer
│       │   │   ├── domain/            # Domain layer
│       │   │   └── presentation/      # UI layer
│       │   ├── core/                  # Core utilities
│       │   ├── di/                    # Dependency injection
│       │   └── theme/                 # UI theme
│       ├── androidMain/kotlin/         # Android-specific
│       └── iosMain/kotlin/            # iOS-specific
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
- **Coil**: Image loading
- **Kotlinx Serialization**: JSON handling

## 🎨 UI Features

- **Coin List**: Displays top cryptocurrencies with real-time data
- **Price Formatting**: Properly formatted prices and percentage changes
- **Color Coding**: Green for profits, red for losses
- **Interactive Charts**: 24-hour price history visualization
- **Loading States**: Proper loading indicators and error handling
- **Responsive Design**: Adapts to different screen sizes

## 🔄 Data Flow

1. **CoinsListViewModel** requests data via use cases
2. **Use cases** interact with repository interfaces
3. **KtorCoinsRemoteDataSource** makes HTTP requests to crypto API
4. **Data is mapped** from DTOs to domain models
5. **UI state updates** flow back to the Compose UI
6. **User interactions** trigger view model actions

## 🧪 Testing

The project includes comprehensive testing setup:
- Unit tests for business logic
- Flow testing with Turbine
- UI testing for Compose components
- Mock implementations for testing

## 📱 Platform Support

- **Android**: Full support with Material Design 3
- **iOS**: Native iOS app using Compose Multiplatform
- **Shared Logic**: 100% code sharing for business logic, networking, and UI

## 🔮 Future Enhancements

- [ ] Portfolio tracking and management
- [ ] Price alerts and notifications
- [ ] Advanced charting features
- [ ] User authentication
- [ ] Offline data caching
- [ ] Additional cryptocurrency exchanges

## 📄 License

This project is open source and available under the MIT License.

---

Built with ❤️ using Kotlin Multiplatform and Compose Multiplatform
