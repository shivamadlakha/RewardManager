package com.customer.points.rewards.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.*;

import javax.swing.event.ListSelectionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.points.rewards.entity.Customer;
import com.customer.points.rewards.entity.Points;
import com.customer.points.rewards.entity.Transactions;
import com.customer.points.rewards.exceptions.DataNotFoundException;
import com.customer.points.rewards.repository.CustomerRepository;
import com.customer.points.rewards.repository.PointRepository;
import com.customer.points.rewards.repository.TransactionRepository;
import com.customer.points.rewards.utils.PointResponse;
import com.customer.points.rewards.utils.RewardingLogic;

@Service
public class RewardService {

	@Autowired
	public PointRepository pointRepository;
	@Autowired
	public TransactionRepository transactionRepository;
	@Autowired
	public RewardingLogic rewardingLogic;
	
	//get all the transactions data
	public Iterable<Transactions> getTxnData(){
		Iterable<Transactions> transactions=transactionRepository.findAll();
		if(transactions!=null ) {
			((Collection<Transactions>) transactions).stream().forEach(transaction->rewardingLogic.fillRewards(transaction));
		}else {
			throw new DataNotFoundException("Data Not Found","No transactions present");
		}
		return transactions;
	}
	
	//get month wise custom rewarding data
	public ResponseEntity<PointResponse> getCustomerDataMonthWise(Integer cId, int months){
		
		LocalDate monthFrom=LocalDate.now().minusMonths(months);  
		LocalDate monthTo= (months==12)?monthFrom.plusMonths(12):monthFrom.plusMonths(1);
		PointResponse pointResponse=new PointResponse();
		
		Integer totalRewards;
		
		List<Points> pointsMonth=pointRepository.findPointsByMonth(cId, monthFrom, monthTo);
		
		if(pointsMonth!=null && !pointsMonth.isEmpty()) {
			
			totalRewards=pointsMonth.stream().mapToInt(Points::getRewards).sum();
			
			List<Transactions> txns= pointsMonth.stream().map(Points::getTransactions).collect(Collectors.toList());
			
			pointsMonth.stream().forEach(point->{
				pointResponse.setId(cId);
				pointResponse.setName(point.getCustomer().getName());
				pointResponse.setRewardsEarned(totalRewards);
				pointResponse.setTransactions(txns);
				});
		}
		else {
			throw new DataNotFoundException("Data Not Found","Check either customer id or month passed in url");
		}
		return new ResponseEntity<>(pointResponse,HttpStatus.OK);
	}
	
}
