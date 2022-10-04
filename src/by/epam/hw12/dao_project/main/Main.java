package by.epam.hw12.dao_project.main;

import by.epam.hw12.dao_project.dao.impl.TxtFindApplianceDAOImpl;
import by.epam.hw12.dao_project.view.ConsoleOutput;

public class Main {

	public static void main(String[] args) {

		ApplianceDBCreator.writeItemsToFile();

		TxtFindApplianceDAOImpl finder = TxtFindApplianceDAOImpl.getInstance();

		ConsoleOutput output = new ConsoleOutput();

		System.out.println("\tAll appliances:");
		output.printAppliances(finder.findAll());
		
		System.out.println("=======================");
		
		System.out.println("\tLaptops with RAM wich is bigger than the given one:");
		output.printAppliances(finder.findLaptopByRamWichIsBiggerThanTheGivenOne(8)); 
		
		System.out.println("=======================");
		
		System.out.println("\tOvens by capacity in range:");
		output.printAppliances(finder.findOvenByCapaciytInRange(30, 45)); 
		

	}

}
