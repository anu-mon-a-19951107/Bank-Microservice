/**
 * 
 */
package com.accounts.data.objects;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author anuantony_
 *
 */
@Entity
@Table(name = "accounts")
@Setter
@Getter
public class Accounts {

	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "account_number")
	@Id
	private Long accountNumber;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "branch_address")
	private String branchAddress;

	@Column(name = "create_dt")
	private LocalDate createDt;
}
