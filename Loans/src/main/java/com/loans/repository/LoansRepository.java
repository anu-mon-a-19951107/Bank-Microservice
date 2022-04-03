/**
 * 
 */
package com.loans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loans.data.objects.Loans;

/**
 * @author anuantony
 *
 */
public interface LoansRepository extends JpaRepository<Loans, Long> {

	public Loans findByLoanNumber(Long loanNumber);

	public List<Loans> findByCustomerId(Long customerId);

	public void deleteByLoanNumber(Long loanNumber);

	public void deleteByCustomerId(Long customerId);
}
