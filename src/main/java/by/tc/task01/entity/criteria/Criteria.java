package by.tc.task01.entity.criteria;

import java.util.*;

/**
 * @author Yura
 * stores the information needed to find appliances in a .xml file
 */
public class Criteria {

	/**
	 * Stores classes that are searchable
	 */
	private static final List<Class<?>> validGroupSearchClasses = new ArrayList<Class<?>>();

	public static List<Class<?>> getValidGroupSearchClasses() {
		return validGroupSearchClasses;
	}

	/**
	 * adds a searchable class
	 * @param validClass
	 */
	public static void addValidGroupSearchClass(Class<?> validClass) {
		validGroupSearchClasses.add(validClass);
	}

	/**
	 * group search name for the current criteria
	 */
	private String groupSearchName;

	/**
	 * search criteria
	 */
	private Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	@Override
	public String toString() {
		return "Criteria{" +
				"groupSearchName='" + groupSearchName + '\'' +
				", criteria=" + criteria +
				'}';
	}

	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}
	
	public Object findCriteriaValue(String searchCriteria) {
		return criteria.get(searchCriteria);
	}

	public Set<String> getCriteriaNames() {
		return this.criteria.keySet();
	}

}
