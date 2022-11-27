package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.ValidationService;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ApplianceWrapper applianceWrapper = new ApplianceWrapper();
		Oven oven = new Oven();
		oven.setCAPACITY(5);
		oven.setDEPTH(4);
		oven.setWIDTH(3);
		oven.setHEIGHT(2);
		oven.setWEIGHT(1);
		oven.setPOWER_CONSUMPTION(1);

		TabletPC tabletPC = new TabletPC();
		tabletPC.setCOLOR("blue");
		tabletPC.setDISPLAY_INCHES(30);
		tabletPC.setBATTERY_CAPACITY(200);
		tabletPC.setFLASH_MEMORY_CAPACITY(2);
		tabletPC.setMEMORY_ROM(32);

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();
		ValidationService validationService = factory.getValidationService();
		//service.save(oven);
		//service.save(tabletPC);
		//////////////////////////////////////////////////////////////////
		Criteria.addValidGroupSearchClass(Laptop.class);
		Criteria.addValidGroupSearchClass(Oven.class);
		Criteria.addValidGroupSearchClass(Refrigerator.class);
		Criteria.addValidGroupSearchClass(Speakers.class);
		Criteria.addValidGroupSearchClass(TabletPC.class);
		Criteria.addValidGroupSearchClass(VacuumCleaner.class);


		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(OvenCriteria.CAPACITY.toString(), 5);

		appliances = service.find(criteriaOven);

		System.out.println("Первый:");
		appliances.forEach(PrintApplianceInfo::print);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(OvenCriteria.HEIGHT.toString(), 2);
		criteriaOven.add(OvenCriteria.DEPTH.toString(), 4);
		criteriaOven.add(OvenCriteria.WEIGHT.toString(), 2);

		appliances = service.find(criteriaOven);

		System.out.println("Второй:");
		appliances.forEach(PrintApplianceInfo::print);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPCCriteria.COLOR.toString(), "bflue");

		System.out.println("Третий:");
		appliances = service.find(criteriaTabletPC);
		appliances.forEach(PrintApplianceInfo::print);

	}

}
