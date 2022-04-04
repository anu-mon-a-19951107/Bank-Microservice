/**
 * 
 */
package com.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loans.data.objects.Loans;
import com.loans.service.LoansService;

/**
 * @author anuantony
 *
 */
@RestController
@RequestMapping("/loans")
public class LoansController {

	/**
	 * LoansService
	 */
	@Autowired
	private LoansService loansService;

	/**
	 * @param loans
	 * @return
	 */
	@PostMapping("/save")
	public String saveLoans(@RequestBody Loans loans) {
		String status = loansService.saveLoans(loans);
		return status != null ? status : null;
	}

	/**
	 * @param loans
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public String updateLoans(@RequestBody Loans loans) throws Exception {
		String status = loansService.updateLoans(loans);
		return status != null ? status : null;
	}

	/**
	 * @param loanNumber
	 * @return
	 */
	@GetMapping("/viewByLoanNumber/{loanNumber}")
	public Loans viewByLoanNumber(@PathVariable("loanNumber") Long loanNumber) {
		Loans loans = loansService.findByLoanNumber(loanNumber);
		return loans != null ? loans : null;
	}

	/**
	 * @param customerId
	 * @return
	 */
	@GetMapping("/viewByCustomerId/{customerId}")
	public List<Loans> viewByCustomerId(@PathVariable("customerId") Long customerId) {
		List<Loans> loanList = loansService.findByCustomerId(customerId);
		return loanList != null ? loanList : null;
	}

	/**
	 * @param loanNumber
	 * @return
	 */
	@GetMapping("/deleteByLoanNumber/{loanNumber}")
	public String deleteByLoanNumber(@PathVariable("loanNumber") Long loanNumber) {
		return loansService.deleteByLoanNumber(loanNumber);
	}

	/**
	 * @param customerId
	 * @return
	 */
	@GetMapping("/deleteByCustomerId/{customerId}")
	public String deleteByCustomerId(@PathVariable("customerId") Long customerId) {
		return loansService.deleteByCustomerId(customerId);
	}
}
