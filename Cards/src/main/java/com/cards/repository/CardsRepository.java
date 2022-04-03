/**
 * 
 */
package com.cards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cards.data.objects.Cards;

/**
 * @author anuantony_
 *
 */
@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

	public List<Cards> findByCustomerId(Long customerId);

	public Cards findByCardNumber(Long cardNumber);
	
	public void deleteById(Long customerId);

	public void deleteByCardNumber(Long cardNumber);
}
