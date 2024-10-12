# Calculator App

A simple yet functional calculator application built using **Android**, **Kotlin**, and **Jetpack Compose**. This app demonstrates the use of **modern Android development best practices**, including **MVVM (Model-View-ViewModel)** architecture and **Clean Architecture** principles.

## Features

- Basic arithmetic operations: addition, subtraction, multiplication, and division.
- Clear input and reset operations.
- Responsive UI with Jetpack Compose.
- Optimized for performance and scalability using Clean Architecture and MVVM.
- User-friendly design, offering smooth interactions.

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Design Principles**: Clean Architecture
- **Build Tool**: Gradle

## Architecture

This project is structured based on the **MVVM** pattern and follows **Clean Architecture** principles:

1. **UI Layer**:
   - Built using Jetpack Compose, handling all the interactions and displaying the data from the ViewModel.
   - Uses **State** in Compose for reactive UI updates.

2. **Domain Layer**:
   - Contains business logic in use cases.
   - Encapsulates the core functionality of the app (e.g., performing calculations).

3. **Data Layer**:
   - Manages data operations. In this case, it processes the inputs and performs calculations.

4. **ViewModel**:
   - Acts as a mediator between the UI and domain layer.
   - Stores the UI state and provides data to the Compose UI in a lifecycle-aware manner.

## Project Structure

