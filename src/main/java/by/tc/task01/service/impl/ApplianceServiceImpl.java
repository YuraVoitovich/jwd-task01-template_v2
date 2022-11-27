package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.exception.ValidationException;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.List;

/**
 * @author Yura
 * this class is an implementation of the ApplianceService interface
 * all methods delegate to ApplianceDAO interface methods
 * @see ApplianceService
 * @see ApplianceDAO
 */
public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public void save(Appliance appliance) {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		applianceDAO.save(appliance);
	}

	/**
	 * returns list with all found appliances and an empty list if nothing was found
	 * @param criteria
	 * @return list with all found appliances and an empty list if nothing was found
	 * @throws ValidationException - if criteria is not valid
	 */
	@Override
	public List<Appliance> find(Criteria criteria) {
		if (!ServiceFactory.getInstance().getValidationService().validate(criteria)) {
			throw new ValidationException(String.format("Criteria: %s isn't valid ", criteria));
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		return applianceDAO.find(criteria);
		
		// you may add your own code here
	}

}

//you may add your own new classes
