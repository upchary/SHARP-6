package com.sharp.sharp.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharp.sharp.entity.OTPValidation;
import com.sharp.sharp.util.Sharp6Validation;

@Repository
public interface OtpVaidateRepositpry extends JpaRepository<OTPValidation, Long> {
	public static final EntityManager entityManager = null;
	/*
	 * @Query(value =
	 * "SELECT * FROM TBL_KPOST_OTPVALIDATION WHERE email = ?1 and password = ?2 and activestatus=1"
	 * , nativeQuery = true) String validateOTP(OTPValidation otpvalidation);
	 */

	static OTPValidation validateOTP(OTPValidation otpvalidation) {

		String queryStr = "select * from users where mobileNumber = ?1 and expireDate = ?2 and sendDate = ?3 and otp = ?4 and otpExpireStatus ='y'and otpValidationStatus = 'y'";
		try {
			javax.persistence.Query query = entityManager.createNativeQuery(queryStr);
			query.setParameter(1, otpvalidation.getMobileNumber());
			query.setParameter(2, otpvalidation.getExpireDate());
			query.setParameter(3, otpvalidation.getSendDate());
			query.setParameter(4, otpvalidation.getOtp());
			OTPValidation singleResult = (OTPValidation) query.getSingleResult();
			if (Sharp6Validation.isEmpty(singleResult)) {
				String strQuery = "update TBL_KPOST_OTPVALIDATION set otpValidationStatus=:expireStatus where mobileNumber=:mobNo and expireDate>=:date "
						+ "and sendDate<=:date and otp=:otp";

				Query query2 = entityManager.createNativeQuery(strQuery);

				query2.setParameter("expireStatus", "Y");
				query2.setParameter("mobNo", otpvalidation.getMobileNumber());
				query2.setParameter("date", otpvalidation.getSendDate());
				query2.setParameter("otp", otpvalidation.getOtp());
				query2.executeUpdate();
				return singleResult;
			}
			return singleResult;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
