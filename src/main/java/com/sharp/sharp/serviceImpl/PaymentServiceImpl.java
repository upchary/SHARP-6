package com.sharp.sharp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharp.sharp.entity.Payments;
import com.sharp.sharp.repository.PaymentGatewayRepository;
import com.sharp.sharp.service.PaymentService;

@Component
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentGatewayRepository gatewayDao;

	@Override
	public Payments savePayment(Payments payment) {
		// TODO Auto-generated method stub
		try {
			Payments retObj = gatewayDao.save(payment);
			return retObj;

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Payments> getAllPayments(String userId) {
		// TODO Auto-generated method stub
		try {
			List<Payments> transactionList = gatewayDao.getAllPayments(userId);
			return transactionList;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Optional<Payments> getTransaction(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<Payments> transaction = gatewayDao.findById(id);
			return transaction;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
