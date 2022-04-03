/**
 * 
 */
package com.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.data.objects.Accounts;
import com.accounts.exception.AccountsCustomException;
import com.accounts.repository.AccountsRepository;

/**
 * @author anuantony_
 *
 */
@Service
public class AccountsService {

	@Autowired
	private AccountsRepository accountsRepository;

	/**
	 * save new data
	 * 
	 * @param accounts
	 * @return saved account details as 'Accounts' object
	 */
	public String save(Accounts accounts) {
		boolean isValid = validation(accounts, "save");
		if (isValid) {
			accountsRepository.save(accounts);
			return "Account of 'Customer Id:" + accounts.getCustomerId() + "' and 'Account Number:"
					+ accounts.getAccountNumber() + "' updated successfully";
		} else {
			return null;
		}
	}

	/**
	 * @param customerId
	 * @return account details for the customer
	 */
	public Accounts findByCustomerId(Long customerId) {
		if (customerId != 0L)
			return accountsRepository.findByCustomerId(customerId);
		else
			throw new AccountsCustomException("'Customer Id' is missing");
	}

	/**
	 * @param customerId
	 * @return account details based on account number
	 */
	public Accounts findByAccountNumber(Long accountNumber) {
		if (accountNumber != 0L)
			return accountsRepository.findByCustomerId(accountNumber);
		else
			throw new AccountsCustomException("'Account Number' is missing");
	}

	/**
	 * update operation
	 * 
	 * @param accounts
	 * @return
	 * @throws Exception
	 */
	public String update(Accounts accounts) throws Exception {
		boolean isValid = validation(accounts, "update");
		if (isValid) {
			accountsRepository.save(accounts);
			return "Account of 'Customer Id:" + accounts.getCustomerId() + "' and 'Account Number:"
					+ accounts.getAccountNumber() + "' updated successfully";
		} else {
			return null;
		}
	}

	/**
	 * @param accounts
	 * @return
	 * @throws Exception
	 */
	private boolean validation(Accounts accounts, String opSpcfcMsg) throws AccountsCustomException {
		Accounts ac1 = accountsRepository.findByCustomerId(accounts.getCustomerId());

		if (ac1 != null) {
			if (ac1.getAccountNumber() != 0L && ac1.getAccountNumber() != accounts.getAccountNumber()) {
				throw new AccountsCustomException(
						"The 'Account Number :" + accounts.getAccountNumber() + "' exists,cannot" + opSpcfcMsg);
			}
		} else {
			Accounts ac2 = accountsRepository.findByAccountNumber(accounts.getAccountNumber());

			if (ac2 != null) {
				if (ac2.getCustomerId() != accounts.getCustomerId() && ac2.getCustomerId() != 0L) {
					throw new AccountsCustomException(
							"The 'Customer Id : " + accounts.getAccountNumber() + "' exists,cannot" + opSpcfcMsg);
				}
			}
		}
		return true;
	}

	/**
	 * @param customerId
	 */
	public String deleteById(Long customerId) {
		try {
			accountsRepository.deleteById(customerId);
		} catch (RuntimeException e) {
			throw new AccountsCustomException("Error occured while delete using 'Customer Id',Check log for more..");
		}
		return "Account updated Successfully";
	}

	/**
	 * @param accounts
	 */
	public String deleteByAccountNumber(Accounts accounts) {
		try {
			accountsRepository.deleteByAccountNumber(accounts.getAccountNumber());
		} catch (RuntimeException e) {
			throw new AccountsCustomException("Error occured while delete using 'Account Number',Check log for more..");
		}
		return "Account updated successfully";
	}
}
