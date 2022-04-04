/**
 * 
 */
package com.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.data.objects.Accounts;
import com.accounts.model.Customer;
import com.accounts.service.AccountsService;

/**
 * @author anuantony_
 *
 */
@RestController
@RequestMapping(value = "/accounts")
public class AccountsController {

	/**
	 * AccountsService
	 */
	@Autowired
	private AccountsService accountsService;

	/**
	 * @param accounts
	 * @return
	 */
	@PostMapping(value = "/create")
	public String createAccounts(@RequestBody Accounts accounts) {
		String saveStatus = accountsService.save(accounts);
		return saveStatus != null?saveStatus:null;
	}

	/**
	 * @param accounts
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/update")
	public String updateAccounts(@RequestBody Accounts accounts) throws Exception {
		String updateStatus = accountsService.update(accounts);
		return updateStatus != null?updateStatus:null;
	}

	/**
	 * @param customer
	 * @return
	 */
	@GetMapping(value = "/viewById")
	public List<Accounts> viewAccountsById(@RequestBody Customer customer) {
		List<Accounts> acDetailList = accountsService.findByCustomerId(customer.getId());
		return acDetailList != null ? acDetailList : null;
	}

	/**
	 * @param accounts
	 * @return
	 */
	@GetMapping(value = "/viewByAcNr")
	public Accounts viewAccountsByAcNr(@RequestBody Accounts accounts) {
		Accounts acDetail = accountsService.findByAccountNumber(accounts.getAccountNumber());
		return acDetail != null ? acDetail : null;
	}

	/**
	 * @param accounts
	 * @return
	 */
	@GetMapping(value = "/deleteById")
	public String deleteById(@RequestBody Accounts accounts) {
		return accountsService.deleteById(accounts.getCustomerId());
	}

	/**
	 * @param accounts
	 * @return
	 */
	@GetMapping(value = "/deleteByAcNr")
	public String deleteByAccountNumber(@RequestBody Accounts accounts) {
		return accountsService.deleteByAccountNumber(accounts);
	}
}
