package com.test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author anuantony
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main.LoanCalc();

	}

	private static void LoanCalc() {

		Double bankInt = 7.5;
		Double borrowedAmt = 800000.0;
		Double returningPrAmt = 500000.0;

		Double boTimeEurVal = 0.0;
		Double currEurVal = 82.0;

		LocalDate borrowDate = LocalDate.of(2020, 1, 1);
		LocalDate today = LocalDate.now();

		Period period = Period.between(borrowDate, today);

		System.out.println("Period between borrowed date and today :=" + period.getYears() + " years,"
				+ period.getMonths() + " months," + period.getDays() + " days.");

		Double bankIntPerMonth = (bankInt / 12);
		Double totalAmtReturning = returningPrAmt;
		Double totalAmtBorrowed = borrowedAmt;

		for (int i = 0; i < period.toTotalMonths(); i++) {
			totalAmtReturning += totalAmtReturning * (bankIntPerMonth / 100);
			totalAmtBorrowed += totalAmtBorrowed * (bankIntPerMonth / 100);
		}

		System.out.println("Total amount decided to give (incl Interest):= " + totalAmtReturning);
		System.out.println("Total amount decided to give (incl Interest) in €:= " + (totalAmtReturning / currEurVal));
		
		System.out.println("Total amount to be given (borrowed amount incl Interest):= " + totalAmtBorrowed);
		System.out.println("Total amount to be given (borrowed amount incl Interest) in €:= " + (totalAmtBorrowed / currEurVal));
		
		System.out.println("Difference:= " + (totalAmtBorrowed - totalAmtReturning));
		System.out.println("Difference in €:= " + ((totalAmtBorrowed / currEurVal) - (totalAmtReturning / currEurVal)));		

	}

}
