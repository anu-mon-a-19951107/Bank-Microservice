/**
 * 
 */
package com.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cards.data.objects.Cards;
import com.cards.service.CardsService;

/**
 * @author anuantony_
 *
 */
@RestController
@RequestMapping(name = "/cards")
public class CardsController {

	/**
	 * CardsService
	 */
	@Autowired
	private CardsService cardsService;

	@PostMapping("/save")
	public String createCards(@RequestBody Cards cards) {
		String status = cardsService.saveCard(cards);
		return status != null ? status : null;
	}

	@PostMapping("/update")
	public String updateCard(@RequestBody Cards cards) {
		String status = cardsService.updateCard(cards);
		return status != null ? status : null;
	}

	@GetMapping("/viewByCardNumber/{cardNumber}")
	public Cards viewByCardNumber(@PathVariable("cardNumber") Long cardNumber) {
		Cards cards = cardsService.findByCardNumber(cardNumber);
		return cards != null ? cards : null;
	}

	@GetMapping("/viewById/{customerId}")
	public List<Cards> viewByCustomerId(@PathVariable("customerId") Long customerId) {
		List<Cards> cardsList = cardsService.findByCustomerId(customerId);
		return cardsList != null ? cardsList : null;
	}

	@GetMapping("/deleteById/{customerId}")
	public String deleteByCustomerId(@PathVariable("customerId") Long customerId) {
		return cardsService.deleteById(customerId);
	}

	@GetMapping("/deleteByCardNumber/{cardNumber}")
	public String deleteByCardNumber(@PathVariable("cardNumber") Long cardNumber) {
		return cardsService.deleteByCardNumber(cardNumber);
	}
}
