package com.customer.points.rewards.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.points.rewards.entity.Customer;
import com.customer.points.rewards.entity.Points;
import com.customer.points.rewards.entity.Transactions;
import com.customer.points.rewards.service.RewardService;
import com.customer.points.rewards.utils.PointResponse;

@RestController
@RequestMapping("/api/reward")
public class CustomerContoller {
	
	@Autowired
	public RewardService rewardService;
	
	//set reward for all the transactions
	@GetMapping("/txn")
	public Iterable<Transactions> getAllTxn(){
		return rewardService.getTxnData();
	}
	
	//get transaction details of customer specific to month mentioned in parameter
	@GetMapping("/customer/{cId}")
	public ResponseEntity<PointResponse> getCustomerByMonth(@PathVariable Integer cId, 
			@RequestParam(value="months",required=false,defaultValue="12") int months){
		return rewardService.getCustomerDataMonthWise(cId, months);
	}
	
}
