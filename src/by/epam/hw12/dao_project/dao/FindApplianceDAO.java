package by.epam.hw12.dao_project.dao;

import java.util.List;

import by.epam.hw12.dao_project.bean.ElectricalAppliance;
import by.epam.hw12.dao_project.bean.Laptop;
import by.epam.hw12.dao_project.bean.Oven;

public interface FindApplianceDAO {
	
	String OVEN_PREFIX = "Oven";
	String LAPTOP_PREFIX = "Laptop";	
	String PATTERN = "\\w+=\\w+\\.\\w+|\\w+=\\w+";

	List<ElectricalAppliance> findAll();
	
	List<Laptop> findLaptopByRamWichIsBiggerThanTheGivenOne(int ram);
	
	List<Oven> findOvenByCapaciytInRange(double fromCapacity, double toCapacity);
	

}
