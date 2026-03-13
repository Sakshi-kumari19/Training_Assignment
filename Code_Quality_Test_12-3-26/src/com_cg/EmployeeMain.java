package com_cg;

import java.util.logging.Logger;

/**
 * @author saksh
 */
public class EmployeeMain {
    private static final Logger LOGGER = Logger.getLogger("EmployeeMain");
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        final Employee emp = new Employee();
        emp.setEmpid(101);
        emp.setName("Sakshi");
        emp.setEmail("sk@gmail.com");

    }

}
