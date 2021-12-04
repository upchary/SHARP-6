package com.sharp.sharp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharp.sharp.entity.Payments;
import com.sharp.sharp.service.PaymentService;
import com.sharp.sharp.util.Constants;
import com.sharp.sharp.util.Sharp6Validation;

@RestController
@RequestMapping("/payment")
public class PaymentGateWayController {

	@Autowired
	private PaymentService gatewayService;

	@PostMapping("/save/")
	public HashMap<String, Object> savePayments(@RequestBody Payments payment) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Payments paymentObj = gatewayService.savePayment(payment);
		if (!Sharp6Validation.isEmpty(paymentObj)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", paymentObj);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("value", "payment submitted failed");
		}

		return resultMap;

	}

	@PostMapping("/getTransaction/")
	public HashMap<String, Object> getTransactionByid(@RequestBody Payments payment) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Optional<Payments> paymentObj = gatewayService.getTransaction(payment.getId());
		if (!Sharp6Validation.isEmpty(paymentObj)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", paymentObj);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("value", "payment details not available try after sometime");
		}

		return resultMap;

	}

	@PostMapping("/getAllTranssactionsByuserId/")
	public HashMap<String, Object> getUserTransactions(@RequestBody Payments payment) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Payments> transactionList = gatewayService.getAllPayments(payment.getUserId());
		if (!Sharp6Validation.isEmpty(transactionList)) {
			resultMap.put(Constants.STATUS, Constants.SUCCESS);
			resultMap.put("value", transactionList);
		} else {
			resultMap.put(Constants.STATUS, Constants.FAILURE);
			resultMap.put("value", "no payments found");
		}

		return resultMap;

	}

}
