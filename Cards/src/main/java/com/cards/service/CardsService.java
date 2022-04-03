/**
 * 
 */
package com.cards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cards.data.objects.Cards;
import com.cards.exception.CardsCustomException;
import com.cards.repository.CardsRepository;

/**
 * @author anuantony_
 *
 */
@Service
public class CardsService {

	/**
	 * CardsRepository
	 */
	@Autowired
	private CardsRepository cardsRepository;

	/**
	 * @param cards
	 * @return
	 */
	public String saveCard(Cards cards) {
		boolean isValid = validation(cards, "save");
		if (isValid) {
			cardsRepository.save(cards);
			return "Card detils of 'Customer Id:" + cards.getCustomerId() + "' saved successfully";
		} else {
			return null;
		}
	}

	public String updateCard(Cards cards) {
		boolean isValid = validation(cards, "update");
		if (isValid) {
			cardsRepository.save(cards);
			return "Card detils of 'Customer Id:" + cards.getCustomerId() + "' updated successfully";
		} else {
			return null;
		}
	}
	
	/**
	 * @param customerId
	 * @return
	 */
	public List<Cards> findByCustomerId(Long customerId) {
		if (customerId != 0L) {
			return cardsRepository.findByCustomerId(customerId);
		} else {
			throw new CardsCustomException("Customer Id is missing");
		}
	}

	/**
	 * @param cardNumber
	 * @return
	 */
	public Cards findByCardNumber(Long cardNumber) {
		if (cardNumber != 0L) {
			return cardsRepository.findByCardNumber(cardNumber);
		} else {
			throw new CardsCustomException("Card Number is missing");
		}
	}

	/**
	 * @param customerId
	 * @return
	 */
	public String deleteById(Long customerId) {
		try {
			cardsRepository.deleteById(customerId);
		} catch (RuntimeException e) {
			throw new CardsCustomException("Error occured while deleting using 'Customer Id',Check log for more..");
		}
		return "Cards deleted succssfully";
	}

	/**
	 * @param cardNumber
	 * @return
	 */
	public String deleteByCardNumber(Long cardNumber) {
		try {
			cardsRepository.deleteByCardNumber(cardNumber);
		} catch (RuntimeException e) {
			throw new CardsCustomException("Error occured while deleting using 'Customer Id',Check log for more..");
		}
		return "Card deleted succssfully";
	}

	/**
	 * @param cards
	 * @param opSpcfcMsg
	 * @return
	 */
	private boolean validation(Cards cards, String opSpcfcMsg) {
		Cards cards1 = cardsRepository.findByCardNumber(cards.getCardNumber());
		if (cards1 != null) {
			if (cards1.getCardNumber() != 0L && cards1.getCardNumber() == cards.getCardNumber()) {
				throw new CardsCustomException("The 'Card Number :" + cards.getCardNumber()
						+ "' exists for this account/customer,cannot" + opSpcfcMsg);
			}
			if (cards1.getAmountUsed() > cards.getTotalLimit()) {
				throw new CardsCustomException(
						"Invalid update of Used amount" + "Used amount should not be greater than total limit");
			}
		}
		return true;
	}
}
