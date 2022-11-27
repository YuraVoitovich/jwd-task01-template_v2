package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yura
 * this class is an implementation of the ApplianceDAO interface
 * all data is stored in xml file
 * @see ApplianceDAO
 */
public class ApplianceDAOImpl implements ApplianceDAO{

	/**
	 * .xml file path
	 */
	private static final String xmlFilePath = "D:\\lol.xml";
	private final JAXBContext context;
	private final Marshaller marshaller;

	private final Unmarshaller unmarshaller;

	public ApplianceDAOImpl() {
		try {
			this.context = JAXBContext.newInstance(ApplianceWrapper.class, Oven.class, Laptop.class, Refrigerator.class, Speakers.class, TabletPC.class, VacuumCleaner.class);
			this.marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			this.unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * saves an appliance in the xml file
	 * if the file already had appliances, adds the appliance to the end of file
	 * @param appliance
	 */
	@Override
	public void save(Appliance appliance) {
		try {
			ApplianceWrapper wrapper = (ApplianceWrapper) context.createUnmarshaller().unmarshal(new File("D:\\lol.xml"));
			wrapper.add(appliance);
			marshaller.marshal(wrapper, new File(xmlFilePath));
		} catch (JAXBException e) {
			ApplianceWrapper wrapper = new ApplianceWrapper();
			wrapper.add(appliance);
			try {
				marshaller.marshal(wrapper, new File(xmlFilePath));
			} catch (JAXBException ex) {
				throw new RuntimeException(ex);
			}
		}

	}

	/**
	 * returns list with all found appliances and an empty list if nothing was found
	 * @param criteria
	 * @return list with all found appliances and an empty list if nothing was found
	 */
	@Override
	public List<Appliance> find(Criteria criteria) {
		ApplianceWrapper wrapper;
		try {
			wrapper = (ApplianceWrapper) context.createUnmarshaller().unmarshal(new File(xmlFilePath));
		} catch (JAXBException e) {
			return new ArrayList<>();
		}
		List<Appliance> appliances = wrapper.getAppliances().stream()
				.filter(o -> o.getClass().getSimpleName().equals(criteria.getGroupSearchName()))
				.collect(Collectors.toList());

		List<Field> fields = Arrays.stream(appliances.get(0).getClass().getDeclaredFields())
				.collect(Collectors.toList());
		for (String str : criteria.getCriteriaNames()) {
			Field field = fields.stream().filter(o -> o.getName().equals(str)).findFirst().get();
			field.setAccessible(true);

			appliances = appliances.stream().filter(o -> {
				try {
					return field.get(o).equals(criteria.findCriteriaValue(str));
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}).collect(Collectors.toList());
		}
		return appliances;

	}
}


//you may add your own new classes