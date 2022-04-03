/**
 * 
 */
package com.cards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cards.data.objects.Cards;
import com.cards.repository.CardsRepository;

/**
 * @author anuantony_
 *
 */
@Service
public class CardsService {

	@Autowired
	private CardsRepository cardsRepository;
	
	
	public long saveCard(Cards cards) {
		
		return 0L;
	}
}
