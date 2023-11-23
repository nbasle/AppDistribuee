/*
 * Created on 26 nov. 2005
 *
 * CatalogDelegate.java
 */
package com.yaps.petstore.common.delegate;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Collection;

import com.yaps.petstore.common.dto.CategoryDTO;
import com.yaps.petstore.common.dto.ItemDTO;
import com.yaps.petstore.common.dto.ProductDTO;
import com.yaps.petstore.common.exception.CheckException;
import com.yaps.petstore.common.exception.CreateException;
import com.yaps.petstore.common.exception.FinderException;
import com.yaps.petstore.common.exception.RemoveException;
import com.yaps.petstore.common.exception.UpdateException;
import com.yaps.petstore.common.rmi.RMIConstant;
import com.yaps.petstore.server.service.catalog.CatalogServiceRemote;

/**
 * @author Veronique
 *
 */
public final class CatalogDelegate implements RMIConstant {
	
	/////-----Private attributes-----/////
	private static CatalogServiceRemote catalogServiceRemote;
	
	/////-----Private methods -----/////
	
	private static CatalogServiceRemote getCatalogService() throws RemoteException {
		try {
			catalogServiceRemote = (CatalogServiceRemote) Naming.lookup(CATALOG_SERVICE_URL);
		} catch(Exception e) {
			throw new RemoteException("Lookup exception", e);
		}
		return catalogServiceRemote;
	}

	/**
	 * Delegates the call to the remote service 
	 * @param categoryDTO
	 */
	public static CategoryDTO createCategory(final CategoryDTO categoryDTO) throws CreateException, CheckException,RemoteException {
		return getCatalogService().createCategory(categoryDTO);
		
	}

	/**
	 * Delegates the call to the remote service
	 * @param productDTO
	 * @return ProductDTO
	 */
	public static ProductDTO createProduct(final ProductDTO productDTO) throws CreateException, CheckException, RemoteException {
		return getCatalogService().createProduct(productDTO);
	}

	/**
	 * Delegates the call to the remote service
	 * @param itemDTO
	 * @return ItemDTO
	 */
	public static ItemDTO createItem(final ItemDTO itemDTO) throws CreateException, CheckException, RemoteException{
		return getCatalogService().createItem(itemDTO);
	}

	/**
	 * Delegate the call to remote service
	 * @param categoryId
	 * @return CategoryDTO
	 */
	public static CategoryDTO findCategory(final String categoryId) throws FinderException, CheckException, RemoteException{
		return getCatalogService().findCategory(categoryId);
	}

	/**
	 * Delegate the call to remote service
	 * @param productId
	 * @return ProductDTO
	 */
	public static ProductDTO findProduct(final String productId) throws FinderException, CheckException, RemoteException{
		return getCatalogService().findProduct(productId);
	}

	/**
	 * Delegate the call to remote service
	 * @param itemId
	 * @return ItemDTO
	 */
	public static ItemDTO findItem(final String itemId) throws FinderException, CheckException, RemoteException{
		return getCatalogService().findItem(itemId);
	}

	/**
	 * Delegate the call to remote service
	 * @return a collection of categories
	 */
	public static Collection findCategories() throws FinderException, RemoteException{
		return getCatalogService().findCategories();
	}

	/**
	 * Delegate the call to remote service
	 * @return a collection of products
	 */
	public static Collection findProducts() throws FinderException,  RemoteException{		
		return getCatalogService().findProducts();
	}

	/**
	 * Delegate the call to remote service
	 * @return a collection of items
	 */
	public static Collection findItems() throws FinderException,  RemoteException {		
		return getCatalogService().findItems();
	}

	/**
	 * Delegate the call to remote service
	 * @param id
	 */
	public static void deleteProduct(final String productId) throws RemoveException, CheckException, RemoteException {
		getCatalogService().deleteProduct(productId);
	}

	/**
	 * Delegates the call to remote service
	 * @param itemId
	 */
	public static void deleteItem(final String itemId) throws RemoveException, CheckException, RemoteException { 
		getCatalogService().deleteItem(itemId);
	}
	/**
	 * Delegates the call to remote service
	 * @param categoryId
	 */
	public static void deleteCategory(final String categoryId) throws RemoveException, CheckException, RemoteException{
		getCatalogService().deleteCategory(categoryId);	
	}
	/**
	 * Delegate a call to remote service
	 * @param productDTO
	 */
	public static void updateProduct(final ProductDTO productDTO) throws UpdateException, CheckException, RemoteException{
		getCatalogService().updateProduct(productDTO);	
	}

	/**
	 * Delegate a call to remote service
	 * @param categoryDTO
	 */
	public static void updateCategory(final CategoryDTO categoryDTO) throws UpdateException, CheckException, RemoteException{
		getCatalogService().updateCategory(categoryDTO);
	}

	/**
	 * Delegate a call to remote service
	 * @param itemDTO
	 */
	public static void updateItem(final ItemDTO itemDTO) throws UpdateException, CheckException, RemoteException{		
		getCatalogService().updateItem(itemDTO);
	}

	

}
