package com.customer.points.rewards.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.customer.points.rewards.entity.Points;
import com.customer.points.rewards.entity.Transactions;

public interface PointRepository extends CrudRepository<Points, Integer>{
	@Query("Select p from Points p where p.customer.id= :cId "
	 		+ "and p.point_date >= :monthFrom and p.point_date < :monthTo")
	 List<Points> findPointsByMonth(@Param("cId") Integer cId
			 ,@Param("monthFrom") LocalDate monthFrom,@Param("monthTo") LocalDate monthTo);
}
