# RewardManager
Allocating Rewards to customers based on there transactional amount
 Extensions used- >
 /api/reward/txn  --> this will allocate the rewards to all the transactions and will return all transactions
 /api/reward/customer/1  --> this will fetch overall rewards of customer id 1 along with transactions details
 /api/reward/customer/2?months=2  --> this will fetch total rewards of customer 2 specific to second last month with transaction details
 Any invlaid customer id or Invalid month number having No data present in database will throw exception and is being handled
 Any other Exception that could occur is also handled globally
