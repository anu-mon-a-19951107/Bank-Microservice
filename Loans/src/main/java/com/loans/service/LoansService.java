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

	@Autowired
	private LoansRepository loansRepository;

	public String saveLoans(Loans loans) {
		Loans loans1 = loansRepository.save(loans);
		if (loans1 != null && loans1.getLoanNumber() != 0L) {
			return "Loan details have saved successfully, Loan Number generated is := " + loans1.getLoanNumber();
		} else {
			return null;
		}
	}

	public String updateLoans(Loans loans) throws Exception {
		boolean isValid = validation(loans);
		if (isValid) {
			loansRepository.save(loans);
			return "Loan details have updated successfully..";
		} else {
			return null;
		}
	}

	private boolean validation(Loans loans) throws LoansCustomException {
		Loans loans1 = loansRepository.findByLoanNumber(loans.getLoanNumber());
		if (loans1 != null && loans1.getLoanNumber() != loans.getLoanNumber()) {
			throw new LoansCustomException(
					"Loan with number " + loans.getLoanNumber() + " does not exists.Cannot be updated...");
		}
		return true;
	}

	public Loans findByLoanNumber(Long loanNumber);

	public List<Loans> findByCustomerId(Long customerId);

	public void deleteByLoanNumber(Long loanNumber);

	public void deleteByCustomerId(Long customerId);
}
