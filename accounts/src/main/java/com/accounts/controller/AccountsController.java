/**
 * 
 */
package com.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private AccountsService accountsService;

	@PostMapping(value = "/create")
	public String createAccounts(@RequestBody Accounts accounts) {
		String saveStatus = accountsService.save(accounts);
		return saveStatus != null?saveStatus:null;
	}

	@PostMapping(value = "/update")
	public String updateAccounts(@RequestBody Accounts accounts) throws Exception {
		String updateStatus = accountsService.update(accounts);
		return updateStatus != null?updateStatus:null;
	}

	@PostMapping(value = "/viewById")
	public Accounts viewAccountsById(@RequestBody Customer customer) {
		Accounts acDetail = accountsService.findByCustomerId(customer.getId());
		return acDetail != null ? acDetail : null;
	}

	@PostMapping(value = "/viewByAcNr")
	public Accounts viewAccountsByAcNr(@RequestBody Accounts accounts) {
		Accounts acDetail = accountsService.findByAccountNumber(accounts.getAccountNumber());
		return acDetail != null ? acDetail : null;
	}

	@PostMapping(value = "/deleteById")
	public String deleteById(@RequestBody Accounts accounts) {
		return accountsService.deleteById(accounts.getCustomerId());
	}

	@PostMapping(value = "/deleteByAcNr")
	public String deleteByAccountNumber(@RequestBody Accounts accounts) {
		return accountsService.deleteByAccountNumber(accounts);
	}
}
