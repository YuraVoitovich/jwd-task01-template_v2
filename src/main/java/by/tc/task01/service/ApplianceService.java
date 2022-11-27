package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

/**
 * @author Yura Voitovich
 *
 * This interface declares some methods for working with appliances
 */
public interface ApplianceService {

	/**
	 * returns all appliances found by the criteria
	 * @param criteria
	 * @return an array, where all found appliances
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * saves appliance in .xml file
	 * @param appliance
	 */
	void save(Appliance appliance);
	
}
