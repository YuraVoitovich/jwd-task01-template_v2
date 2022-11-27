package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ValidationService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Yura
 * this class is an implementation of the ValidationService interface
 * @see ValidationService
 */
public class ValidationServiceImpl implements ValidationService {


	/**
	 * returns true if criteria group search name is the name of a class that is stored in
	 * ValidGroupSearchClasses static field of Criteria class and all criteria types are the
	 * same as class field types
	 * @param criteria
	 * @return true if criteria is valid
	 */
	public boolean validate(Criteria criteria) {
		Optional<Class<?>> groupSearchClassOptional = Criteria.getValidGroupSearchClasses().stream()
				.filter(o -> o.getSimpleName().equals(criteria.getGroupSearchName()))
				.findFirst();
		if (!groupSearchClassOptional.isPresent())  {
			return false;
		}

		List<Field> fields = Arrays.stream(groupSearchClassOptional.get().getDeclaredFields()).collect(Collectors.toList());

		for (String str : criteria.getCriteriaNames()) {
			Optional<Field> fieldOptional = fields.stream().filter(o -> o.getName().equals(str)).findFirst();
			if (!fieldOptional.isPresent()) {
				return false;
			}
			Class<?> clazz = criteria.findCriteriaValue(str).getClass();
			Class<?> clazz2 = fieldOptional.get().getType();
			if (!criteria.findCriteriaValue(str).getClass().equals(fieldOptional.get().getType())) {
				return false;
			}
		}


		return true;
	}

}

//you may add your own new classes