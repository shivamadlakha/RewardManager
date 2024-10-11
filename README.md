# RewardManager
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.  
  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). 

ER DIAGRAM SNAPSHOT 

https://github.com/user-attachments/assets/762b9f83-0496-45e2-a1c2-f100aa1868b3


ENDPOINTS

/api/reward/txn  : Fetches all the transactions of all the customers and in backend calculates the reward point for all the transactions. 


/api/reward/customer/customerId?months=monthNumber : Fetches total reward points earned for the mentioned month of specific Customer


/api/reward/customer/customerId : Fetches overall total reward points earned for the specific Customer


/actuator/health : checking service health




