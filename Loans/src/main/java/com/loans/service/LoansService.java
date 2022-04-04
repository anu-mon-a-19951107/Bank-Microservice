/**
 * 
 */
package com.loans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loans.data.objects.Loans;
import com.loans.exception.LoansCustomException;
import com.loans.repository.LoansRepository;

/**
 * @author anuantony
 *
 */
public class LoansService {

	/**
	 * LoansRepository
	 */
	@Autowired
	private LoansRepository loansRepository;

	/**
	 * @param loans
	 * @return
	 */
	public String saveLoans(Loans loans) {
		Loans loans1 = loansRepository.save(loans);
		if (loans1 != null && loans1.getLoanNumber() != 0L) {
			return "Loan details have saved successfully, Loan Number generated is := " + loans1.getLoanNumber();
		} else {
			return null;
		}
	}

	/**
	 * @param loans
	 * @return
	 * @throws Exception
	 */
	public String updateLoans(Loans loans) throws Exception {
		boolean isValid = validation(loans);
		if (isValid) {
			loansRepository.save(loans);
			return "Loan details have updated successfully..";
		} else {
			return null;
		}
	}

	/**
	 * @param loanNumber
	 * @return
	 */
	public Loans findByLoanNumber(Long loanNumber) {
		Loans loans = loansRepository.findByLoanNumber(loanNumber);
		if (loans != null) {
			return loans;
		} else {
			throw new LoansCustomException("No loan record exists with loan number := " + loanNumber);
		}
	}

	/**
	 * @param customerId
	 * @return
	 */
	public List<Loans> findByCustomerId(Long customerId) {
		List<Loans> loanList = loansRepository.findByCustomerId(customerId);
		if (loanList != null) {
			return loanList;
		} else {
			throw new LoansCustomException("The customer " + customerId + "do not have any loans attached.");
		}

	}

	/**
	 * @param loanNumber
	 * @return
	 */
	public String deleteByLoanNumber(Long loanNumber) {
		try {
			loansRepository.deleteByLoanNumber(loanNumber);
		} catch (RuntimeException e) {
			throw new LoansCustomException(
					"Error occured while deleting the loan record with loan number " + loanNumber);
		}
		return "Loan record deleted successfully";
	}

	/**
	 * @param customerId
	 * @return
	 */
	public String deleteByCustomerId(Long customerId) {
		try {
			loansRepository.deleteByCustomerId(customerId);
		} catch (RuntimeException e) {
			throw new LoansCustomException(
					"Error occured while deleting the loan record of the customer :=" + customerId);
		}
		return "Loan record deleted successfully";
	}

	/**
	 * @param loans
	 * @return
	 * @throws LoansCustomException
	 */
	private boolean validation(Loans loans) throws LoansCustomException {
		Loans loans1 = loansRepository.findByLoanNumber(loans.getLoanNumber());
		if (loans1 != null && loans1.getLoanNumber() != loans.getLoanNumber()) {
			throw new LoansCustomException(
					"Loan with number " + loans.getLoanNumber() + " does not exists.Cannot be updated...");
		}
		return true;
	}
}
