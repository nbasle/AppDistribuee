/*
 * Created on 26 nov. 2005
 * CustomerDelegate.java
 */
package com.yaps.petstore.common.delegate;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Collection;

import com.yaps.petstore.common.dto.CustomerDTO;
import com.yaps.petstore.common.exception.CheckException;
import com.yaps.petstore.common.exception.CreateException;
import com.yaps.petstore.common.exception.FinderException;
import com.yaps.petstore.common.exception.RemoveException;
import com.yaps.petstore.common.exception.UpdateException;
import com.yaps.petstore.common.rmi.RMIConstant;
import com.yaps.petstore.server.service.customer.CustomerServiceRemote;

/**
 * @author Veronique
 *
 */
public final class CustomerDelegate implements RMIConstant {

	/////-----Attribute-----/////
	private static CustomerServiceRemote customerServiceRemote;
	
	/////-----Private method-----/////
	private static CustomerServiceRemote getCustomerService() throws RemoteException {
		try {
			customerServiceRemote = (CustomerServiceRemote) Naming.lookup(CUSTOMER_SERVICE_URL);
		} catch(Exception e) {
			throw new RemoteException("Lookup exception", e);
		}
		return customerServiceRemote;
	}
	/**
	 * Delegates call to remote service
	 * @param customerDTO
	 */
	public static CustomerDTO createCustomer(final CustomerDTO customerDTO) throws CreateException, CheckException,RemoteException {
		return getCustomerService().createCustomer(customerDTO);
		
	}

	/**
	 * Delegates call to a remote service
	 * @param string
	 * @return
	 */
	public static CustomerDTO findCustomer(final String customerId) throws FinderException, CheckException,RemoteException{
		return getCustomerService().findCustomer(customerId);
	}

	/**
	 * Delegates call to remote service
	 * @return Collection
	 */
	public static Collection findCustomers() throws FinderException, RemoteException{
		return getCustomerService().findCustomers();
	}

	/**
	 * Delegate call to remote service
	 * @param id
	 */
	public static void deleteCustomer(final String customerId) throws RemoveException, CheckException, RemoteException {		
		getCustomerService().deleteCustomer(customerId);
	}

	/**
	 * Delagete call to remote service
	 * @param customerDTO
	 */
	public static void updateCustomer(final CustomerDTO customerDTO) throws UpdateException, CheckException,RemoteException{		
		getCustomerService().updateCustomer(customerDTO);
	}

}
