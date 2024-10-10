package com.customer.points.rewards.utils;




import java.util.List;

import com.customer.points.rewards.entity.Transactions;

public class PointResponse {

	private Integer id;
	private String name;
	private Integer rewardsEarned;
	private List<Transactions> transactions;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRewardsEarned() {
		return rewardsEarned;
	}
	public void setRewardsEarned(Integer rewardsEarned) {
		this.rewardsEarned = rewardsEarned;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
	
	
}
