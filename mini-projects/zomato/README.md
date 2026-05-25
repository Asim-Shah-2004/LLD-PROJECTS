# Zomato LLD Mini Project

## Problem Statement
Build a small, object-oriented food ordering system that supports restaurants, menus, carts, multiple order types (delivery and pickup), payment strategies, and order scheduling. The design should demonstrate common LLD patterns such as factories, strategies, and managers.

## Features
- Restaurant and menu management
- Cart with items and cost calculation
- Delivery and pickup orders
- Instant and scheduled order creation
- Payment strategies (card and UPI)
- Order listing and notification output

## How To Run
From the project root:

```powershell
./run.ps1
```

The script compiles the Java sources, runs the driver in `Zomato`, and cleans build artifacts.

## UML Diagram
```mermaid
classDiagram
    class Zomato {
        +main(String[])
    }

    class RestaurantManager {
        -List~Restaurant~ restaurants
        -static RestaurantManager instance
        +getInstance() RestaurantManager
        +addRestaurant(Restaurant)
        +listRestaurant() List~Restaurant~
    }

    class OrderManager {
        -List~Order~ orders
        -static OrderManager instance
        +getInstance() OrderManager
        +addOrder(Order)
        +listOrders()
    }

    class User {
        -String name
        -String address
        -int userId
        -Cart cart
        +getCart() Cart
    }

    class Cart {
        -Restaurant restaurant
        -List~MenuItem~ items
        +addItem(MenuItem)
        +getCost() double
    }

    class Restaurant {
        -int restaurantId
        -String name
        -String location
        -List~MenuItem~ menu
    }

    class MenuItem {
        -String code
        -String name
        -double price
    }

    class Order {
        <<abstract>>
        -int orderId
        -User user
        -Restaurant restaurant
        -List~MenuItem~ items
        -PaymentStrategy paymentStrategy
        -double total
        -String scheduled
        +processPayment(double) boolean
        +getType() String
    }

    class DeliveryOrder {
        -String userAddress
        +getType() String
    }

    class PickupOrder {
        -String restaurantAddress
        +getType() String
    }

    class OrderFactory {
        <<interface>>
        +createOrder(User, Cart, Restaurant, List~MenuItem~, PaymentStrategy, double, String) Order
    }

    class NowOrderFactory {
        +createOrder(...)
    }

    class ScheduledOrderFactory {
        -String scheduleTime
        +createOrder(...)
    }

    class PaymentStrategy {
        <<interface>>
        +pay(double)
    }

    class CreditCardPaymentStrategy {
        +pay(double)
    }

    class UpiPaymentStrategy {
        +pay(double)
    }

    class NotificationService {
        +notify(Order)
    }

    class TimeUtils {
        +getCurrentTime() String
    }

    Zomato --> RestaurantManager
    Zomato --> OrderManager
    Zomato --> OrderFactory
    Zomato --> PaymentStrategy
    OrderFactory <|.. NowOrderFactory
    OrderFactory <|.. ScheduledOrderFactory
    Order <|-- DeliveryOrder
    Order <|-- PickupOrder
    Order --> PaymentStrategy
    OrderManager --> Order
    RestaurantManager --> Restaurant
    Restaurant --> MenuItem
    Cart --> MenuItem
    User --> Cart
    NotificationService --> Order
    NowOrderFactory --> TimeUtils
```
