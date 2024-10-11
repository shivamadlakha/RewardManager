package com.customer.points.rewards;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.customer.points.rewards.controller.CustomerContoller;
import com.customer.points.rewards.entity.Customer;
import com.customer.points.rewards.entity.Points;
import com.customer.points.rewards.entity.Transactions;
import com.customer.points.rewards.repository.PointRepository;
import com.customer.points.rewards.service.RewardService;

@WebMvcTest(CustomerContoller.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@InjectMocks
	private RewardService rewardService;
	@Mock
	private PointRepository pointRepository;
	
	@Test
	public void getAllTxnTest() throws Exception{
		LocalDate dt=LocalDate.parse("05-08-2024");	
		List<Transactions> collect = Stream.of
		(new Transactions(5001,"amazon",BigDecimal.valueOf(10.0),dt,"rewarded"
				,new Customer(1,"sagar"))).collect(Collectors.toList());
		when(rewardService.getTxnData()).thenReturn((Iterable<Transactions>)collect);
		
		this.mockMvc.perform(get("/api/reward/txn"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content()
						.string(containsString("{\"id\":5001,\"description\":\"amazon\",\"rewardFlag\":\"rewarded\"}")))
				.andDo(print());	
					
		}
	
	@Test
	public void getCustomerByMonthTest() throws Exception{
		LocalDate dt=LocalDate.parse("05-08-2024");	
		
		List<Points> lp=Stream.of(
				new Points(1,10,dt,new Customer(1,"sagar"),new Transactions(5001,"amazon",BigDecimal.valueOf(10.0),dt,"rewarded"
				,new Customer(1,"sagar")))
				).collect(Collectors.toList());
		
		when(pointRepository.findPointsByMonth(1, LocalDate.parse("05-09-2024"), LocalDate.parse("05-10-2024")))
		.thenReturn(lp);
		
		this.mockMvc.perform(get("/api/reward/customer/1?months=1"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content()
						.string(containsString("{\"id\":1,\"rewardsEarned\":10}")))
				.andDo(print());	
					
		}

	
}
