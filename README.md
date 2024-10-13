# Rewards Program API 
Welcome to the Rewards Program API! This API allows retailers to manage a customer rewards program where customers earn points based on their purchases. This README will guide you through the setup, endpoints, and usage of the API.

## Table of Contents - 
- Features
- Technologies
- Installation
- API Endpoints
- Example Reward Calculation
- ER Diagram
- Request/Response Postman Screenshots

###  Features 
-  Simple and intuitive RESTful API design.
-  Lightweight and efficient, built with Spring Boot.
-  Calculate Month wise and total reward points for customers
  
###  Technologies 
 - **Spring Boot**: For creating RESTful APIs
 - **Java**: The programming language used
 - **Maven**: For project management and dependency management
 - **JUnit**: For testing

###  Installation

1. **Clone the repository**: ```bash git clone https://github.com/shivamadlakha/RewardManager.git cd rewards ```
2. **Build the project**: ```bash mvn clean install ```
3. **Run the application**: ```bash mvn spring-boot:run ```
   
The application will start on `http://localhost:8080`.

###  API Endpoints

1. **Fetch Trasnactions & Calculate Rewards**: ```/api/reward/txn```
2. **Fetch Overall rewarding data of Specific Customer**: ```/api/reward/customer/{customerid}```
3. **Fetch Month wise rewarding data of Specific Customer**: ```/api/reward/customer/{customerid}?months={monthNumber} ```
4. **Service Heatlh monitoring**: ``` /actuator/health```

###  Example Reward Calculation
  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). 

###  ER DIAGRAM SNAPSHOT 

![ERDiagram](https://github.com/user-attachments/assets/017e6195-10d2-477a-944f-b35c3434e711)

###  Request/Response Postman Screenshots

- /api/reward/txn - Rewarding all fetching all transactions ![rewarding](https://github.com/user-attachments/assets/43a2853b-8998-4797-870b-b2f2c627061b)

- /api/reward/txn - Hitting the rewarding logic again  ![alreadyRewarded](https://github.com/user-attachments/assets/45b801c7-76df-4789-b472-07451a81fb0d)
- /api/reward/customer/1 - getting overall rewards and transaction info of Customer with id 1 ![customer1overall](https://github.com/user-attachments/assets/6d600eb8-d555-4375-8f73-6bf5967dbe55)

- /api/reward/customer/1?months=3 - getting rewards and transaction info of Customer with id 1 specific to 3rd month from now ![customer1month3](https://github.com/user-attachments/assets/fec6f9a3-2413-4058-a08e-8ff6375b58b5)

- /api/reward/customer/1?months=1 - getting rewards and transaction info of Customer with id 1 specific to 1st month from now ![customer1NoData](https://github.com/user-attachments/assets/c710c66a-94a1-4505-947a-c5b5bbbdd760)
