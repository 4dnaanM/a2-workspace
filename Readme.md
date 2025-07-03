## **Project Overview**

SportyShoes is a full-stack e-commerce web application built using **Spring Boot**, designed to manage an online shoe store. The application provides both **administrative** and **user-facing** functionalities with a clean separation of concerns following the **MVC (Model-View-Controller)** architecture pattern.

---

## **Technology Stack**

### **Backend Technologies:**
- **Spring Boot 3.4.7** - Main application framework
- **Spring Data JPA** - Object-Relational Mapping and database operations
- **Spring MVC** - Web framework for handling HTTP requests
- **Java 17** - Programming language
- **Maven** - Dependency management and build tool

### **Database:**
- **MySQL** - Primary database (configurable)
- **H2 Database** - In-memory database for testing

### **Frontend Technologies:**
- **Thymeleaf** - Server-side template engine
- **HTML5** - Markup language
- **CSS** - Styling (basic styling implemented)

### **Development Tools:**
- **Spring Boot DevTools** - Hot reloading during development
- **Maven** - Build automation

---

## **System Architecture**

### **Package Structure:**
```
com.main/               # Application entry point
com.bean/              # Entity classes (Data models)
com.dao/               # Repository interfaces (Data Access Layer)
com.service/           # Business logic layer
com.controller/        # Web controllers (Presentation layer)
src/main/resources/
├── templates/         # Thymeleaf HTML templates
├── static/           # Static resources (CSS, JS, images)
└── application.properties # Configuration file
```

---

## **Core Entities (Data Models)**

### **1. User Entity**
- **Fields**: `userId`, `userName`, `userRole`, `password`
- **Features**: 
  - Auto-generated unique user ID
  - Unique username constraint
  - Role-based access (admin/user)
  - Password authentication support

### **2. Product Entity**
- **Fields**: `productId`, `productName`, `productCategory`, `productPrice`
- **Features**:
  - Auto-generated product ID
  - Categorized products for easy filtering
  - Immutable pricing (no setter for productPrice)

### **3. Purchase Entity**
- **Fields**: `purchaseId`, `purchaseUser`, `purchaseProduct`, `purchaseDateTime`, `purchaseQuantity`, `purchaseTotalPrice`
- **Relationships**:
  - **Many-to-One** with User (multiple purchases per user)
  - **Many-to-One** with Product (multiple purchases per product)
- **Features**:
  - Automatic timestamp recording
  - Total price calculation
  - Quantity tracking

---

## **Key Features**

### **👑 Admin Features**

#### **1. Product Management**
- ✅ **Add New Products**: Create products with name, category, and price
- ✅ **Update Product Categories**: Modify existing product categories
- ✅ **View All Products**: Browse complete product catalog
- 🔧 **URL Endpoints**: `/admin/products` (GET/POST), `/admin/products/add`, `/admin/products/update`

#### **2. User Management**
- ✅ **Browse All Users**: View registered users
- ✅ **Search Users**: Filter users by username
- ✅ **Add New Users**: Register new users with roles
- 🔧 **URL Endpoints**: `/admin/users` (GET/POST)

#### **3. Purchase Reports & Analytics**
- ✅ **View All Purchases**: Complete purchase history
- ✅ **Filter by Date**: Reports for specific dates
- ✅ **Filter by Category**: Category-wise purchase analysis
- ✅ **Add Manual Purchases**: Administrative purchase entry
- 🔧 **URL Endpoints**: `/admin/purchases` (GET/POST)

### **👤 User Features**

#### **1. Product Browsing**
- ✅ **View Product Catalog**: Browse available shoes
- ✅ **Product Details**: See prices, categories, and specifications
- 🔧 **URL Endpoints**: `/user/{userId}`

#### **2. Purchase Management**
- ✅ **Make Purchases**: Buy products with quantity selection
- ✅ **Purchase Confirmation**: Instant feedback on transactions
- ✅ **User-Specific Dashboard**: Personalized experience with user ID
- 🔧 **URL Endpoints**: `/user/{userId}` (GET/POST)

### **🔐 Authentication & Security**

#### **Login System**
- ✅ **Role-Based Access**: Different dashboards for admin/user
- ✅ **Session Management**: Secure authentication tracking
- ✅ **Route Protection**: Admin areas require authentication
- ✅ **Logout Functionality**: Session invalidation
- 🔧 **URL Endpoints**: `/login`, `/logout`

#### **Access Control**
- **Admin Routes**: `/admin/*` - Requires admin privileges
- **User Routes**: `/user/{userId}` - User-specific access
- **Public Routes**: `/`, `/login` - Open access

---

## **Database Schema**

### **Tables:**
1. **`user`** - Stores user information and credentials
2. **`product`** - Product catalog with pricing and categorization
3. **`purchase`** - Transaction records linking users and products

### **Relationships:**
- **User → Purchase**: One-to-Many (Users can have multiple purchases)
- **Product → Purchase**: One-to-Many (Products can be purchased multiple times)
- **Purchase**: Junction entity with additional data (quantity, total price, timestamp)

---

## **Web Interface (Templates)**

### **📱 User Interface Pages:**
1. **loginPage.html** - Authentication portal
2. **userDashboard.html** - Product browsing and purchase interface
3. **adminDashboard.html** - Administrative control center
4. **manageProducts.html** - Product management interface
5. **browseUsers.html** - User management interface
6. **purchaseReports.html** - Analytics and reporting dashboard

### **🎨 UI Features:**
- **Responsive Forms**: Dynamic user input handling
- **Data Tables**: Organized display of products, users, and purchases
- **Real-time Feedback**: Success/error messages
- **Role-Based Navigation**: Different interfaces for different user types

---

## **Service Layer Architecture**

### **Business Logic Services:**

#### **ProductService**
- Product creation and management
- Category updates
- Product retrieval and listing

#### **UserService**
- User registration and authentication
- Role-based access verification
- User search and management

#### **PurchaseService**
- Transaction processing
- Purchase history management
- Reporting and analytics

---

## **Configuration & Deployment**

### **Application Configuration:**
- **Database**: MySQL with configurable connection parameters
- **JPA**: Hibernate with automatic schema generation
- **Server**: Embedded Tomcat server (default port 8080)
- **Template Engine**: Thymeleaf with automatic resource resolution

### **Spring Boot Features Utilized:**
- **Auto-Configuration**: Minimal manual configuration required
- **Component Scanning**: Automatic bean discovery and injection
- **JPA Repositories**: Simplified database operations
- **MVC Auto-Configuration**: Web layer setup

---

## **Current Status & Capabilities**

### **✅ Fully Implemented:**
- Complete CRUD operations for all entities
- Role-based authentication system
- Administrative dashboard with full management capabilities
- User purchase interface
- Reporting and analytics features
- Session-based security

### **🔧 Key Technical Achievements:**
- **Clean Architecture**: Proper separation of concerns
- **Database Integration**: Full JPA/Hibernate implementation
- **Template Engine**: Dynamic web page generation
- **Error Handling**: Comprehensive error management
- **Route Security**: Protected administrative functions

---

## **Use Cases**

### **For Shoe Store Administrators:**
1. **Inventory Management**: Add/update shoe products
2. **Customer Service**: View and manage registered users
3. **Business Analytics**: Track sales by date/category
4. **Order Management**: Monitor and process purchases

### **For Customers:**
1. **Product Discovery**: Browse available shoes
2. **Purchase Process**: Buy shoes with quantity selection
3. **Account Management**: Personal dashboard access

---

This SportyShoes application demonstrates a complete e-commerce solution with modern web development practices, proper database design, and user-friendly interfaces for both administrators and customers. The system is scalable and follows industry-standard patterns for maintainability and extensibility.
