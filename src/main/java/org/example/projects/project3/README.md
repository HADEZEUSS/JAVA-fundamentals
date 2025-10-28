# E-Commerce Management System (Console Application)

A Java-based console e-commerce application that supports **PostgreSQL** and **JSON fallback modes**, allowing users to browse products, manage a shopping cart, and place orders — complete with receipt generation and stock tracking.

---

## How to Run

Steps:

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Run the `Main.java` file.

> ⚠️ If PostgreSQL is not available, the system automatically switches to JSON/In-Memory mode.

---

## PostgreSQL Tables

```sql
-- Users Table
CREATE TABLE users (
    user_id BIGSERIAL PRIMARY KEY,      
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Products Table
CREATE TABLE products (
    product_id BIGSERIAL PRIMARY KEY,  
    name TEXT NOT NULL,
    price NUMERIC(12,2) NOT NULL,
    category TEXT,
    stock_quantity INT NOT NULL
);

-- Orders Table
CREATE TABLE orders (
    order_id BIGSERIAL PRIMARY KEY,    
    user_id BIGINT NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    total_amount NUMERIC(12,2),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status TEXT
);

-- Order Items Table
CREATE TABLE order_items (
    order_item_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL REFERENCES orders(order_id) ON DELETE CASCADE,
    product_id BIGINT NOT NULL REFERENCES products(product_id) ON DELETE SET NULL,
    quantity INT NOT NULL,
    price NUMERIC(12,2) NOT NULL
);
```

## 🚀 Features

### 1. Product Management
- Add new products (ID, Name, Price, Category, Stock Quantity)
- Update product stock quantities
- Search products by **ID** or **name**
- List products by:
    - **Price range**
    - **Category**
    - **Availability (in stock)**
- **Admin Mode** enables extra commands:
    - `addproduct name|price|CATEGORY|qty`
    - `update stock productId|newQty`
    - `delete product productId`
- Uses **Stream API** for filtering and searching

### 2. User & Shopping Cart Management
- User registration (ID, Name, Email)
- Add products to cart with quantity
- Remove products from cart
- View cart contents and calculate total cost

### 3. Order Processing
- Validate stock availability before order placement
- Deduct ordered quantities from stock automatically
- Clear cart after successful checkout
- Throws `InsufficientStockException` if any product is low on stock
- Maintain user’s order history
- Sort orders by date or total price
- Generate textual receipt for each successful order

### 4. JSON Fallback Mode
- Automatically switches to JSON/In-Memory mode if PostgreSQL is unavailable
- Loads initial product catalog from `products.json`
- All operations continue working without a database

### 5. Admin Mode
- Admin commands include:
    - Add products
    - Update product stock
    - Delete products
- Prevents deleting products that are part of existing orders


> 💡 Notes
>
> - Receipts are saved to `receipts/order_{order_id}.txt`.
> - Product deletion is blocked if the product exists in any order.
> - The system gracefully falls back to JSON mode if the DB is unreachable.
