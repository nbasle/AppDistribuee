/*
 * Created on 26 nov. 2005
 *
 * CatalogService.java
 */
package com.yaps.petstore.server.service.catalog;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.yaps.petstore.common.dto.CategoryDTO;
import com.yaps.petstore.common.dto.ItemDTO;
import com.yaps.petstore.common.dto.ProductDTO;
import com.yaps.petstore.common.exception.CheckException;
import com.yaps.petstore.common.exception.CreateException;
import com.yaps.petstore.common.exception.FinderException;
import com.yaps.petstore.common.exception.RemoveException;
import com.yaps.petstore.common.exception.UpdateException;
import com.yaps.petstore.common.logging.Trace;

import com.yaps.petstore.server.domain.category.Category;
import com.yaps.petstore.server.domain.item.Item;
import com.yaps.petstore.server.domain.product.Product;
import com.yaps.petstore.server.service.AbstractRemoteService;

/**
 * @author Veronique
 * CatalogService.java
 */
public final class CatalogService extends AbstractRemoteService implements CatalogServiceRemote {

	/**
	 * Constructor
	 * @throws RemoteException
	 */
	public CatalogService() throws RemoteException {
	}

	/**
	 * Constructor
	 **/
	public CategoryDTO createCategory(final CategoryDTO categoryDTO) throws CreateException, CheckException {
		final String mname = "createCategory";
		Trace.entering(_cname, mname, categoryDTO);
		if(categoryDTO == null)
			throw new CreateException("Category object is null");
		
		// Transfoms DTO into domain object
		final Category category = new Category(categoryDTO.getId(), categoryDTO.getName(),categoryDTO.getDescription());
		
		 // Creates object
		category.create();
		
		//Transforms domain object into DTO
		final CategoryDTO result = transformCategory2DTO(category);
		
		Trace.exiting(_cname, mname, result);
		return result;
	}

	/**
	 * Transform Category into categoryDTO
	 * @param category
	 * @return categoryDTO
	 */
	private CategoryDTO transformCategory2DTO(final Category category) {
		final CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		categoryDTO.setDescription(category.getDescription());
		return categoryDTO;
	}

	/**
	 * find category from id
	 */
	public CategoryDTO findCategory(final String categoryId) throws FinderException, CheckException {
		final String mname ="findCategory";
		Trace.entering(_cname, mname, categoryId);
		
		final Category category = new Category();
		
		// Finds the object
		category.findByPrimaryKey(categoryId);
		
		// transforms doamin objet into DTO
		final CategoryDTO  categoryDTO = transformCategory2DTO(category);
		
		Trace.exiting(_cname, mname, categoryDTO);		
		return categoryDTO;
	}

	/** 
	 * Delete category
	 */
	public void deleteCategory(final String categoryId) throws RemoveException,CheckException {
		final String mname ="deleteCategory";
		Trace.entering(_cname, mname, categoryId);
		
		final Category category =  new Category();
		
		// Checks if the object exists
		try {
			category.findByPrimaryKey(categoryId);
		} catch(FinderException e) {
			throw new RemoveException("Category must exist to be deleted");
		}
		 //Deletes the object
		category.remove();
	}

	/**
	 * Update category
	 * @param categoryDTO
	 */
	public void updateCategory(final CategoryDTO categoryDTO) throws UpdateException,CheckException {
		final String mname ="updateCategory";
		Trace.entering(_cname, mname, categoryDTO);
		
		if(categoryDTO == null)
			throw new UpdateException("Category object is null");
		
		final Category category = new Category();
		
		//Checks if the object exists
		try {
			category.findByPrimaryKey(categoryDTO.getId());
		} catch(FinderException e) {
			throw new UpdateException("Category must exist to be updated");
		}
		
		// Transforms DTO into domain object
		category.setName(categoryDTO.getName());
		category.setDescription(categoryDTO.getDescription());
		
		// updates the object
		category.update();

	}

	/**
	 *  find all  categories
	 */
	public Collection findCategories() throws FinderException {
		final String mname ="findCategories";
		Trace.entering(_cname, mname);
		
		// Finds all the objects
		final Collection categories = new Category().findAll();
		
		// Transforms domain objects into DTOs
		final Collection categoriesDTO = transformCategories2DTO(categories);
		
		Trace.exiting(_cname, mname, new Integer(categoriesDTO.size()));
		return categoriesDTO;
	}

	/**
	 * transform categories object into categoriesDTO
	 * @param categories
	 * @return
	 */
	private Collection transformCategories2DTO(final Collection categories) {
		final Collection categoriesDTO = new ArrayList();
		for(Iterator iterator = categories.iterator(); iterator.hasNext();){
			final Category category = (Category) iterator.next();
			categoriesDTO.add(transformCategory2DTO(category));
		}
		return categoriesDTO;
	}

	/**
	 * Create a product
	 */
	public ProductDTO createProduct(final ProductDTO productDTO) throws CreateException, CheckException {
		final String mname ="createProduct";
		final Category category = new Category();
		Trace.entering(_cname, mname, productDTO);
	
		if(productDTO == null)
			
			throw new CreateException("Product object is null");
		
		//Transforms DTO into domain object
		
		try {
		
		category.findByPrimaryKey(productDTO.getCategoryId());
		
		// Transforms domain object into DTO		
		
		} catch( FinderException e){
			throw new CreateException("Category must exist to create a product");
		} catch(CheckException e) {
			throw new CheckException("Invalid category");
		}
		
		final Product product = new Product(productDTO.getId(), productDTO.getName(), productDTO.getDescription(), category);
		
		// Creates the object
		product.create();
		
		ProductDTO result= transformProduct2DTO(product);
		Trace.exiting(_cname, mname, result);
		return result;
	}

	/**
	 * Transform product in DTO
	 * @param product
	 * @return productDTO
	 */
	private ProductDTO transformProduct2DTO(final Product product) {
		final ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setCategoryName(product.getCategory().getName());
		return productDTO;
	}

	/**
	 *  find product
	 */
	public ProductDTO findProduct(final String productId) throws FinderException,CheckException {
		final String mname ="findProduct";
		Trace.entering(_cname, mname, productId);
		
		final Product product = new Product();
		
		// Finds the object
		product.findByPrimaryKey(productId);
		
		//Transforms domain object into DTO
		final ProductDTO productDTO = transformProduct2DTO(product);
		
		Trace.exiting(_cname, mname, productDTO);
		return productDTO;
	}

	/**
	 * Delete product
	 */
	public void deleteProduct(final String productId) throws RemoveException, CheckException {
		final String mname ="deleteProduct";
		Trace.entering(_cname, mname, productId);
		
		final Product product = new Product();
		
		// Checks if the object exists
		try {
			product.findByPrimaryKey(productId);
		} catch(FinderException e) {
			throw new RemoveException("Product must exit to be deleted");
		}

		// Deletes the object
		product.remove();
	}

	/**
	 *  update the product
	 */
	public void updateProduct(final ProductDTO productDTO) throws UpdateException, CheckException {
		final String mname ="updateProduct";
		Trace.entering(_cname, mname, productDTO);
		
		if(productDTO == null)
			throw new UpdateException("Product object is null");
		
		Product product = new Product();
		
		//Checks if the object exists
		try {
			product.findByPrimaryKey(productDTO.getId());
		} catch(FinderException e) {
			throw new UpdateException("Product must exist to be updated");
		}
		
		//Transforms DTO into domain object
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setCategory(new Category(productDTO.getCategoryId()));
		
		// Updates the object
		product.update();

	}

	/**
	 * fin all products
	 */
	public Collection findProducts() throws FinderException {
		final String mname ="findProducts";
		Trace.entering(_cname, mname);
		
		// Finds all the objects
		final Collection products = new Product().findAll();
		
		//Transforms domain objects into DTOs
		final Collection productsDTO = transformProduct2DTOs(products);
		
		Trace.exiting(_cname, mname, new Integer(productsDTO.size()));
		return productsDTO;
	}

	/**
	 * Transforma collection of product in a collection of productDTO
	 * @param products
	 * @return productsDTO
	 */
	private Collection transformProduct2DTOs(final Collection products) {
		final Collection productsDTO = new ArrayList();
		for (Iterator iterator=products.iterator(); iterator.hasNext();) {
			final Product product = (Product) iterator.next();
		    productsDTO.add(transformProduct2DTO(product));
		}
		return productsDTO;
	}

	/**
	 * Create item
	 */
	public ItemDTO createItem(final ItemDTO itemDTO) throws CreateException, CheckException {
		final Product product = new Product();
		final String mname ="createItem";
		
		Trace.entering(_cname, mname,itemDTO);
		
		if(itemDTO == null)
			throw new CreateException("Item object is null");
		
		try {
		 product.findByPrimaryKey(itemDTO.getProductId());
		}
		catch(FinderException e) {
			throw new CreateException("Product mus exist to create an item");
		} catch(CheckException e) {
			throw new CheckException("Invalid product");
		}
			
		// Transforms DTO into domain object
		final Item item = new Item(itemDTO.getId(),itemDTO.getName(), itemDTO.getUnitCost(), product);
		
		//Creates the object
		item.create();
		
		// Transforms domain object into DTO
		final ItemDTO result = transformItem2DTO(item);
		
		Trace.exiting(_cname, mname, result);
		return result;
	}

	/**
	 * transform item into itemDTO
	 * @param item
	 * @return itemDTO
	 */
	private ItemDTO transformItem2DTO(final Item item) {
		final ItemDTO itemDTO = new ItemDTO();
		itemDTO.setId(item.getId());
		itemDTO.setName(item.getName());
		itemDTO.setProductId(item.getProduct().getId());
		itemDTO.setProductName(item.getProduct().getName());
		itemDTO.setUnitCost(item.getUnitCost());
		return itemDTO;
	}

	/**
	 * 
	 */
	public ItemDTO findItem(final String itemId) throws FinderException, CheckException {
		final String mname ="findItem";
		Trace.entering(_cname, mname, itemId);
		
		final Item item = new Item();
		
		// Finds the object
		item.findByPrimaryKey(itemId);
		
		// Transforms domain object into DTO
		final ItemDTO itemDTO = transformItem2DTO(item);
		
		Trace.exiting(_cname, mname, itemDTO);
		
		return itemDTO;
	}

	/** 
	 * delete item
	 */
	public void deleteItem(final String itemId) throws RemoveException,CheckException {
		final String mname =  "deleteItem";
		Trace.entering(_cname, mname, itemId);
		
		final Item item = new Item();
		
		// Checks if the object exists
		try {
			item.findByPrimaryKey(itemId);
		} catch(FinderException e) {
			throw new RemoveException("Item must exist to be deleted");
		}
		
		// Deletes the object
		item.remove();

	}

	/**
	 * update item
	 */
	public void updateItem(final ItemDTO itemDTO) throws UpdateException, CheckException {
		final String mname ="updateItem";
		Trace.entering(_cname, mname, itemDTO);
		
		if(itemDTO == null)
			throw new UpdateException("Item object is null");
		
		final Item item = new Item();
		
		// Checks if the object exists
		try {
			item.findByPrimaryKey(itemDTO.getId());
		} catch(FinderException e) {
			throw new UpdateException("Item must exist to be updated");
		}
		
		// Transforms DTO into domain object
		item.setId(itemDTO.getId());
		item.setName(itemDTO.getName());
		item.setProduct(new Product(itemDTO.getProductId()));
		item.setUnitCost(itemDTO.getUnitCost());
		
		// Updates the object
		item.update();
	}

	/**
	 */
	public Collection findItems() throws FinderException {
		final String mname = "findItems";
		Trace.entering(_cname, mname);
		
		// Finds all the objects
		final Collection items = new Item().findAll();
		
		// Transforms domain objects into DTOs
		final Collection itemsDTO = transformItems2DTOs(items);
		
		Trace.exiting(_cname, mname, new Integer(itemsDTO.size()));
		return itemsDTO;
	}

	/**
	 * Transform object collection into DTO collection
	 * @param items
	 * @return itemsDTOs
	 */
	private Collection transformItems2DTOs(final Collection items) {
		final Collection itemsDTO = new ArrayList();
		for(Iterator iterator = items.iterator(); iterator.hasNext();){
			final Item item = (Item) iterator.next();
			itemsDTO.add(transformItem2DTO(item));			
		}
		return itemsDTO;
	}

}
