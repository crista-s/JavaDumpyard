package com.capgemini.tcc.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.invalidInput;
import com.capgemini.tcc.service.IPatientService;
import com.capgemini.tcc.service.PatientService;

public class Client {

	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		IPatientService ips = new PatientService();
		PatientBean patient = new PatientBean();
		Scanner sc = new Scanner(System.in);
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		System.out.println("Please select the operation you want to perform");
		System.out.println("1. Add Patient Information\n"
				+ "2. Search Patient by Id\n" + "3.Exit");

		System.out.println("Please enter your choice");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter the name of the Patient: ");
			String name = br.readLine();
			System.out.println("Enter Patient Age: ");
			int age = sc.nextInt();
			System.out.println("Enter Patient phone number: ");
			String phone = sc.next();
			System.out.println("Enter Description: ");
			String description = br.readLine();
			patient.setPatient_Name(name);
			patient.setAge(age);
			patient.setDescription(description);
			patient.setPhone(phone);

			try {
				if (ips.isValid(patient)) {
					int id = ips.addDetails(patient);
					System.out
							.println("Patient Information stored successfully for patient id="
									+ id);

				}

			} catch (invalidInput msg) {
				System.err.println(msg.getMessage());

			}
			break;
		case 2:
			try {
				System.out
						.println("Enter the Patient id of the Patient you want to search");

				int pid = sc.nextInt();
				PatientBean patient1 = ips.search(pid);
				if (patient1 == null) {
					throw new invalidInput("There is no patient with this ID");
				} else {
					System.out.println("Name of the Patient: "
							+ patient1.getPatient_Name());
					System.out.println("Age: " + patient1.getAge());
					System.out.println("Phone Number: " + patient1.getPhone());
					System.out.println("Description: "
							+ patient1.getDescription());
					String date = patient1.getConsultation_Date().toString();
					System.out.println("Consultation Date:"
							+ date.substring(0, 10));

				}
			} catch (invalidInput msg) {
				System.err.println(msg.getMessage());
			}
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid choice");
			break;

		}

	}
}
