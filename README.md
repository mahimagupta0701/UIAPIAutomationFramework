# UI & API Automation Framework

## 📌 Project Overview

This project demonstrates a unified automation framework for both **UI** and **API** testing.  
It is built using:
- **BDD Cucumber with Java**
- **Selenium for UI**
- **REST Assured for API**
- **Maven** for build management
- **GitHub Actions** for CI/CD integration

---

## 🌐 Technologies & Tools Used

| Tool            | Purpose                                           |
|-----------------|---------------------------------------------------|
| **Java**        | Core programming language                         |
| **Cucumber**    | BDD framework for readable test cases             |
| **Selenium**    | UI automation for web-based applications          |
| **REST Assured**| API testing library for RESTful services          |
| **Maven**       | Build & dependency management                     |
| **JUnit**       | Test runner integration with Cucumber             |
| **GitHub Actions** | CI/CD pipeline integration                    |

---

## 🔍 What’s Being Tested

### UI (React + Node.js Web App)
- **Login Functionality**
- **Create Post**
- **Verify Post Creation**
- **Delete Post**

### API (Swagger PetStore - Node.js backend)
- **POST** – Create new pet
- **GET** – Retrieve created pet by ID
- **PUT** – Update existing pet details
- **DELETE** – Remove pet by ID

---

## 📁 Project Structure
UIAPIAutomationFramework/
├── src/
│   ├── main/
│   │   ├── client/
│   │   │   └── Pet.java
│   │   └── java/
│   │       └── util/
│   │           └── [Utility Classes]
│
│   └── test/
│       └── java/
│           ├── apistepdefinitions/
│           │   └── PetStepDefinitions.java
│           │
│           ├── config/
│           │   └── ConfigReader.java
│           │
│           ├── hooks/
│           │   └── [Cucumber Hooks Files]
│           │
│           ├── pages/
│           │   ├── LoginPage.java
│           │   └── PostPage.java
│           │
│           ├── runners/
│           │   └── TestRunner.java
│           │
│           ├── steps/
│           │   ├── LoginSteps.java
│           │   └── PostSteps.java
│           │
│           └── util/
│               ├── WebDriverHelper.java
│               └── WebDriverWaitUtil.java
│
├── src/
│   └── test/
│       └── resources/
│           ├── features/
│           │   ├── login.feature
│           │   ├── post.feature
│           │   └── apiCRUD.feature
│           │
│           ├── payload/
│           │   └── pet.json
│           │
│           └── config.properties
│
├── pom.xml
└── README.md



---

## ▶️ How to Run

Make sure you have Java and Maven installed.

```bash
# Clone the repo
git clone https://github.com/yourusername/UIAPIAutomationFramework.git
cd UIAPIAutomationFramework

# Run the tests
mvn clean install





