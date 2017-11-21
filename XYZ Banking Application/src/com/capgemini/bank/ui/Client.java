package com.capgemini.bank.ui;

import java.util.Scanner;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.exception.ErrorException;
import com.capgemini.bank.service.DemandDraftService;
import com.capgemini.bank.service.IDemandDraftService;
//import org.apache.log4j.PropertyConfigurator;

public class Client {

	static Scanner sc = new Scanner(System.in);
	static DemandDraft demanddraft = new DemandDraft();
	static IDemandDraftService ids = new DemandDraftService();

	public static void main(String[] args) {
		
		//PropertyConfigurator.configure("lo4j.properties");
		
		int ch;		
		
		do {
			System.out.println("1) Enter Demand Draft Details");
			System.out.println("2) Print Demand Draft");
			System.out.println("3) Exit");
			ch = sc.nextInt();


			switch (ch) {
			case 1:
				getInput();
				break;
			case 2:
				display();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
			}
		} while (ch != 3);
	}

	private static void display() {

		System.out.print("Enter Transaction ID");
		int transactionId = sc.nextInt();
		demanddraft.setTransaction_id(transactionId);
		 try {
			if(ids.isValidID(transactionId))
			 {
				 DemandDraft draft1;
					try {
						draft1 = ids.getDemandDraftDetails(transactionId);
						System.out.println("Name of the bank: XYZ");
						int amount = draft1.getDd_amount();
						int comm = draft1.getDd_commission();
						int total = amount + comm;
						System.out.println("DD Amount       :" + "Rs." + amount);
						System.out.println("DD Commission   :" + "Rs." + comm);
						System.out.println("Total Amount    :" + "Rs." + total);
						System.out.println("Remarks         :" + draft1.getDd_description());

					} catch (ErrorException error) {
						System.err.print(error);
					}
			 }
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void getInput() {

		System.out.print("Enter the name of the customer : ");
		demanddraft.setCustomer_name(sc.next());
		System.out.print("\nEnter customer phone number : ");
		demanddraft.setPhone_number(sc.next());
		System.out.print("\nIn favor of : ");
		demanddraft.setIn_favor_of(sc.next());
		System.out.print("\nEnter Demand Draft amount (in Rs) : ");
		demanddraft.setDd_amount(sc.nextInt());
		System.out.print("\nEnter Remarks : ");
		demanddraft.setDd_description(sc.next());
		try {
			if(ids.isValidate(demanddraft)){
			int id;
			try {
				id = (ids.addDemandDraftDetails(demanddraft));
				System.out
						.println("Your Draft request has been successfully registered along with the "
								+ id);
			} catch (ErrorException error) {

				System.err.print(error.getMessage());
			}

		

}
		} catch (ErrorException error) {
			System.err.print(error);
		}
	}
	}
