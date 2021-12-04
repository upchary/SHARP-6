package com.sharp.sharp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.Payments;

@Repository
public interface PaymentGatewayRepository extends JpaRepository<Payments, Integer> {
	@Query(value = "select * payments  WHERE userid =?1 ", nativeQuery = true)
	List<Payments> getAllPayments(String userId);

}
