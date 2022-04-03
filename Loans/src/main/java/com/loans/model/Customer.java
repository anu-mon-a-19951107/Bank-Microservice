/**
 * 
 */
package com.loans.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author anuantony_
 *
 */
@Setter
@Getter
@ToString
public class Customer {

	private long id;

	private String fistName;

	private String lastName;

	private LocalDate dob;

	private String address;
}
