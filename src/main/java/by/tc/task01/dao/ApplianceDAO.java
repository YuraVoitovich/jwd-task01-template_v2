package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;



/**
 * @author Yura Voitovich
 *
 * this dao interface declares some methods for working with appliances
 * all methods are identical to ApplianceService methods
 * @see by.tc.task01.service.ApplianceService
 */
public interface ApplianceDAO {
	List<Appliance> find(Criteria criteria);

	void save(Appliance appliance);
}
