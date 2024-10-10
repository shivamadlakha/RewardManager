package com.customer.points.rewards.utils;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.points.rewards.entity.Points;
import com.customer.points.rewards.entity.Transactions;
import com.customer.points.rewards.repository.PointRepository;
import com.customer.points.rewards.repository.TransactionRepository;

@Component
public class RewardingLogic {
	
	@Autowired
	public PointRepository pointRepository;
	@Autowired
	public TransactionRepository transactionRepository;
	
	 public int calculatePoints(BigDecimal amount){
		 int points=0;
		 int convertedAmount=amount.intValue();
		 
		 if(convertedAmount>100) {
			 points+=(convertedAmount-100)*2;
			 convertedAmount=100;
		 }
		 if(convertedAmount>50) {
			 points+=(convertedAmount-50);
		 }
		 return points;
	 }
	 
	 public void fillRewards(Transactions transaction) {
		 if(transaction.getRewardFlag()==null) {
			 int reward=calculatePoints(transaction.getAmount());
			 Points point=new Points();
			 point.setRewards(reward); 
			 point.setCustomer(transaction.getCustomer());
			 point.setTransactions(transaction);
			 point.setPoint_date(transaction.getCreation_date());
			 pointRepository.save(point);
			 transaction.setRewardFlag("rewarded");
			 transactionRepository.save(transaction);
		 }
		 else {
			 
		 }
		 
		 }
 }
