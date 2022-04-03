/**
 * 
 */
package com.loans.data.objects;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author anuantony
 *
 */
@Entity
@Data
@Table(name = "loans")
public class Loans {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_number")
	private Long loanNumber;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "start_dt")
	private LocalDate startDt;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "total_loan")
	private Double totalLoan;

	@Column(name = "amount_paid")
	private Double amountPaid;

	@Column(name = "outstanding_amount")
	private Double outstandingAmount;

	@Column(name = "create_dt")
	private LocalDate createDt;

}
