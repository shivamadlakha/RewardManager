package com.customer.points.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;

import com.customer.points.rewards.entity.Customer;
import com.customer.points.rewards.entity.Points;
import com.customer.points.rewards.entity.Transactions;
import com.customer.points.rewards.repository.PointRepository;
import com.customer.points.rewards.repository.TransactionRepository;
import com.customer.points.rewards.service.RewardService;
import com.customer.points.rewards.utils.PointResponse;
import com.customer.points.rewards.utils.RewardingLogic;

public class PointServiceTest {

	@InjectMocks
	private RewardService rewardService;
	@Mock
	private TransactionRepository transactionRepository;
	@Mock
	private PointRepository pointRepository;
	@Spy
	private RewardingLogic rewardingLogic;
	
	@Test
	public void testPointsLessThan50() {
		BigDecimal amount=BigDecimal.valueOf(10);
		int points=rewardingLogic.calculatePoints(amount);
		assertEquals(0,points);
	}
	@Test
	public void testPointsbw50and100() {
		BigDecimal amount=BigDecimal.valueOf(80);
		int points=rewardingLogic.calculatePoints(amount);
		assertEquals(30,points);
	}
	@Test
	public void testPointsgreaterThan50() {
		BigDecimal amount=BigDecimal.valueOf(230);
		int points=rewardingLogic.calculatePoints(amount);
		assertEquals(310,points);
	}
	@Test
	public void testGetTxns() {
		LocalDate dt=LocalDate.parse("05-08-2024");	
		when(transactionRepository.findAll())
		.thenReturn(Stream.of
				(new Transactions(5001,"amazon",BigDecimal.valueOf(10.0),dt,"rewarded"
						,new Customer(1,"sagar"))).collect(Collectors.toList()));
		
		assertEquals(1,((List<Transactions>) rewardService.getTxnData()).size());
	}
	
	@Test
	public void testMonthRewards() {
		LocalDate dt=LocalDate.parse("05-08-2024");	
		List<Points> lp=Stream.of(
				new Points(1,10,dt,new Customer(1,"sagar"),new Transactions(5001,"amazon",BigDecimal.valueOf(10.0),dt,"rewarded"
				,new Customer(1,"sagar")))
				).collect(Collectors.toList());
		
		when(pointRepository.findPointsByMonth(1, LocalDate.parse("05-08-2024"), LocalDate.parse("05-09-2024")))
		.thenReturn(lp);
		
		 ResponseEntity<PointResponse> customerDataMonthWise = rewardService.getCustomerDataMonthWise(1, 1);
		
		assertEquals(10,customerDataMonthWise.getBody().getRewardsEarned());
		}
}