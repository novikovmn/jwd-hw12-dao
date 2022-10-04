package by.epam.hw12.dao_project.view;

import java.util.List;

public class ConsoleOutput {
	
	public <T> void printAppliances(List<T> appliances){
		for (T electricalAppliance : appliances) {
			System.out.println(electricalAppliance);
		}
	}

}
