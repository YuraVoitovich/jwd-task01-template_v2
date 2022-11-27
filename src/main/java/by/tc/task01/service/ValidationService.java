package by.tc.task01.service;

import by.tc.task01.entity.criteria.Criteria;


/**
 * @author Yura
 * This interface declares method validate
 */
public interface ValidationService {
    /**
     * returns true if criteria is valid
     * @param criteria
     * @return true if criteria is valid
     */
    boolean validate(Criteria criteria);

}
