package com.qa.ims.controllers.mockito;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.controller.CustomerController;


@ExtendWith(MockitoExtension.class)
public class CustControllerTest {
	
	@Mock
	//PetShop is the file in main
	private CustomerDAO mockShop;
	
	
	@InjectMocks
	//Controller is the file in main
	private CustomerController controller;
	
	//test customer
		Customer cust1 = new Customer("test col", "test name");
		Customer cust1ID = new Customer(1, "test col", "test name");
		Customer cust2ID = new Customer(2, "test blk", "test title");
		Customer cust2 = new Customer("test blk", "test title");

		@Test
		public void addCustControllerTest() {
			
			//Doesn't actually add a bird to the db
			
			Mockito.when(mockShop.create(cust1)).thenReturn(cust1ID);
			
			Customer result;
			
			result = controller.create();
			
			Assertions.assertSame(cust1ID, result);

		}
}
