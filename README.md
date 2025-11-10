#  ATM Interface System (Java)

## Overview
This is a simple ATM simulation program in Java that allows users to perform basic banking operations such as checking transaction history, withdrawing, depositing, and transferring money.  
It is designed using object-oriented programming (OOP) concepts like classes, objects, and encapsulation.

---

##  Features
- ✅ User login using User ID and PIN  
- ✅ Withdraw money with balance check  
- ✅ Deposit money to your account  
- ✅ Transfer money to another registered user  
- ✅ View transaction history  
- ✅ Safe exit option  

---

##  How It Works
1. The program starts by asking for your User ID and PIN.  
2. After successful login, an ATM menu appears.  
3. You can choose any of the following:
   - View transaction history  
   - Withdraw money  
   - Deposit money  
   - Transfer money to another user  
   - Quit the session  
4. Every action updates your transaction history and balance automatically.

---

## Default Users
| User ID | PIN  | Balance |
|----------|------|----------|
| 101      | 1234 | ₹5000    |
| 102      | 5678 | ₹8000    |
| 103      | 0000 | ₹10000   |

---

##  How to Run the Program
1. Open this file in **VS Code**, **IntelliJ IDEA**, or any Java IDE.  
2. Compile and run the file using:
   ```bash
   javac ATMInterface.java
   java ATMInterface
3.Enter a valid User ID and PIN from the above table.
4.Follow the on-screen menu to perform transactions

---
##  Concepts Used
- Classes and Objects  
- Encapsulation  
- Collections (ArrayList, HashMap)  
- Methods and Reusability  
- Console-based Interaction  

---

##  Purpose
This project is ideal for beginners learning Java and object-oriented programming.  
It helps understand how real-world banking operations can be implemented in code.

---

##  Example Output
===== Welcome to the ATM System =====
Enter User ID: 101
Enter PIN: 1234

Login Successful!

----- ATM Menu -----
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
Enter your choice: 2
Enter amount to withdraw: 1000
Withdrawal successful! Remaining balance: ₹4000
