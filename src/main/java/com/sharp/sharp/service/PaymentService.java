package com.sharp.sharp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sharp.sharp.entity.Payments;

@Service
@Transactional
public interface PaymentService {

	Payments savePayment(Payments payment);

	List<Payments> getAllPayments(String userId);

	Optional<Payments> getTransaction(int id);

}
