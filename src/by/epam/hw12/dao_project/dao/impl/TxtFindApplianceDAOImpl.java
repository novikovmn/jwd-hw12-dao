package by.epam.hw12.dao_project.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import by.epam.hw12.dao_project.bean.ElectricalAppliance;
import by.epam.hw12.dao_project.bean.Laptop;
import by.epam.hw12.dao_project.bean.Oven;
import by.epam.hw12.dao_project.dao.FindApplianceDAO;

public final class TxtFindApplianceDAOImpl implements FindApplianceDAO {

	private static final TxtFindApplianceDAOImpl instance = new TxtFindApplianceDAOImpl();

	private final File file = new File("data" + File.separator + "appliance_db.txt");

	private final int OVEN_PROPERTY_LENGTH = 3;
	private final int LAPTOP_PROPERTY_LENGTH = 5;

	private TxtFindApplianceDAOImpl() {

	}

	public static TxtFindApplianceDAOImpl getInstance() {
		return instance;
	}

	@Override
	public List<ElectricalAppliance> findAll() {

		List<ElectricalAppliance> result = new ArrayList<ElectricalAppliance>();

		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			List<String> allFile = bufferedReader.lines().collect(Collectors.toList());

			for (String line : allFile) {

				Pattern pattern = Pattern.compile(PATTERN);
				Matcher matcher = pattern.matcher(line);

				if (line.startsWith(LAPTOP_PREFIX)) {
					Laptop laptop;

					String[] laptopProperties = new String[LAPTOP_PROPERTY_LENGTH];
					int index = 0;

					while (matcher.find()) {
						laptopProperties[index++] = matcher.group().split("=")[1];
					}

					laptop = new Laptop(laptopProperties[0], Double.parseDouble(laptopProperties[1]),
							laptopProperties[2], Integer.parseInt(laptopProperties[3]),
							Boolean.parseBoolean(laptopProperties[4]));

					result.add(laptop);

				} else if (line.startsWith(OVEN_PREFIX)) {
					Oven oven;

					String[] ovenProperties = new String[OVEN_PROPERTY_LENGTH];
					int index = 0;

					while (matcher.find()) {
						ovenProperties[index++] = matcher.group().split("=")[1];
					}

					oven = new Oven(ovenProperties[0], Double.parseDouble(ovenProperties[1]),
							Integer.parseInt(ovenProperties[2]));

					result.add(oven);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Laptop> findLaptopByRamWichIsBiggerThanTheGivenOne(int ram) {
		List<Laptop> temp = new ArrayList<Laptop>();
		List<Laptop> result = new ArrayList<Laptop>();

		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			List<String> allFile = bufferedReader.lines().collect(Collectors.toList());

			for (String line : allFile) {

				Pattern pattern = Pattern.compile(PATTERN);
				Matcher matcher = pattern.matcher(line);

				if (line.startsWith(LAPTOP_PREFIX)) {
					Laptop laptop;

					String[] laptopProperties = new String[LAPTOP_PROPERTY_LENGTH];
					int index = 0;

					while (matcher.find()) {
						laptopProperties[index++] = matcher.group().split("=")[1];
					}

					laptop = new Laptop(laptopProperties[0], Double.parseDouble(laptopProperties[1]),
							laptopProperties[2], Integer.parseInt(laptopProperties[3]),
							Boolean.parseBoolean(laptopProperties[4]));

					temp.add(laptop);
				}
			}

			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getRam() > ram) {
					result.add(temp.get(i));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Oven> findOvenByCapaciytInRange(double fromCapacity, double toCapacity) {
		List<Oven> temp = new ArrayList<Oven>();
		List<Oven> result = new ArrayList<Oven>();

		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			List<String> allFile = bufferedReader.lines().collect(Collectors.toList());

			for (String line : allFile) {

				Pattern pattern = Pattern.compile(PATTERN);
				Matcher matcher = pattern.matcher(line);

				if (line.startsWith(OVEN_PREFIX)) {
					Oven oven;

					String[] ovenProperties = new String[OVEN_PROPERTY_LENGTH];
					int index = 0;

					while (matcher.find()) {
						ovenProperties[index++] = matcher.group().split("=")[1];
					}

					oven = new Oven(ovenProperties[0], Double.parseDouble(ovenProperties[1]),
							Integer.parseInt(ovenProperties[2]));

					temp.add(oven);
				}

			}

			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getCapacity() >= fromCapacity && temp.get(i).getCapacity() <= toCapacity) {
					result.add(temp.get(i));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
