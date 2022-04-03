/**
 * 
 */
package com.accounts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.data.objects.Accounts;

/**
 * @author anuantony_
 *
 */
@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long>{
	
	public List<Accounts> findByCustomerId(Long value);
	
	public Accounts findByAccountNumber(Long accountNumber);

	public void deleteById(Long customerId);
	
	public void deleteByAccountNumber(Long accountNumber);
}
