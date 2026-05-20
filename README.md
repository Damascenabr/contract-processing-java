# interface_Aula03 — Contract Processing with Payment Interface

A Java project developed as a hands-on exercise on the use of **interfaces** and **dependency injection**, applying the Dependency Inversion Principle (DIP) from SOLID.

---

## 📋 Description

The system simulates the processing of installments for a financial contract, calculating interest and fees through an online payment service. The payment logic is decoupled from the contract service via an interface, making it possible to swap the payment provider (e.g., PayPal, Stripe) without changing the rest of the code.

---

## 🏗️ Project Structure

```
src/
├── application/
│   └── Program.java                  # Application entry point
└── model/
    ├── entities/
    │   ├── Contract.java             # Contract entity
    │   └── Installment.java          # Installment entity
    └── service/
        ├── OnlinePaymentService.java # Payment interface
        ├── PaypalService.java        # PayPal implementation
        └── ContractService.java      # Contract processing service
```

---

## ⚙️ How It Works

1. The user provides the contract details (number, date, total value) and the number of installments.
2. `ContractService` divides the total value into basic installment amounts.
3. For each installment, the following are calculated:
   - **Interest** (`interest`): `installmentValue × monthlyRate × monthNumber`
   - **Payment fee** (`paymentFee`): `(installmentValue + interest) × feePercentage`
4. The generated installments are added to the contract and displayed with their due date and final amount.

### PaypalService Rates

| Parameter       | Value |
|-----------------|-------|
| Payment fee     | 2%    |
| Monthly interest| 1%    |

---

## 🖥️ Sample Execution

```
Enter the contract details:
Number Contract: 8493
Date dd/MM/yyyy: 25/06/2018
Value of Contract: 600.00
Enter the number of Installment: 3

Installments:
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12
```

---

## 🔌 `OnlinePaymentService` Interface

```java
public interface OnlinePaymentService {
    double paymentFee(double amount);
    double interest(double amount, int months);
}
```

Any class implementing this interface can be injected into `ContractService`, making the system extensible without modifying existing code.

---

## 🚀 How to Run

### Prerequisites

- Java 17+ (project configured for Java 25 in Eclipse)
- Eclipse IDE (recommended) or any Java-compatible IDE

### Steps

1. Import the project into Eclipse via **File → Import → Existing Projects into Workspace**.
2. Select the project root folder.
3. Run the `application.Program` class as a **Java Application**.

---

## 🧩 Concepts Applied

- **Interface** — contract between `ContractService` and the payment provider
- **Dependency Injection** — `PaypalService` is injected via constructor
- **Dependency Inversion Principle (DIP)** — `ContractService` depends on the abstraction, not the concrete implementation
- **Encapsulation** — entities with getters/setters and business logic isolated in service classes
- **`LocalDate` and `DateTimeFormatter`** — date handling with the `java.time` API

---

## 📁 Technologies

- **Java** (JavaSE-25)
- **Eclipse IDE**
- No external dependencies
