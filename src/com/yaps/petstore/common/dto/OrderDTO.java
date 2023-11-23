/*
 * Created on 26 nov. 2005
 *
 * OrderDTO.java
 */
package com.yaps.petstore.common.dto;

import java.util.Collection;
import java.util.Date;

/**
 * @author Veronique
 *
 */
public final class OrderDTO implements DataTransfertObject {
	/////-----Attributes-----/////
	private String _id;
	private String _firstname;
	private String _lastname;
	private String _street1;
	private String _street2;
	private String _country;
	private String _city;
	private String _state;
	private String _zipcode;
	private String _creditCardExpiryDate;
	private String _creditCardNumber;
	private String _creditCardType;
	private String _customerId;
	private Date _orderDate;
	private Collection _orderline;
	
	
	public OrderDTO() {
		
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param street1
	 * @param city
	 * @param zip
	 * @param country
	 */
	
	public OrderDTO(final String firstname, final String lastname, final String street1, final String city, final String zip, final String country) {
		_firstname = firstname;
		_lastname = lastname;
		_street1 = street1;
		_city = city;
		_zipcode = zip;
		_country = country;
				
	}
/////-----Accessors param Id-----/////
	/**
	 * Accessor set
	 * @param id
	 */
	public void setId(final String id) {		
		_id = id;
	}
	/**
	 * Accessor get
	 * @param id
	 */
	public String getId() {
		return _id;		
	}
	/////-----Accessors param country-----/////
	/**
	 * Accessor set
	 * @param country
	 */
	public void setCountry(final String country) {		
		_country = country;
	}
	/**
	 * Accessor get
	 * @return country
	 */
	public String getCountry() {		
		return _country;
	}
	/////-----Accessors param city -----/////
	/**
	 * Accessor set
	 * @param city
	 */
	public void setCity(final String city) {		
		_city = city;
	}
	/**
	 * Accessor get
	 * @return city
	 */
	public String getCity() {		
		return _city;
	}
/////-----Accessors creditCardExpiryDate----/////
	/**
	 * Accessor set
	 * @param creditCardExpiryDate
	 */
	public void setCreditCardExpiryDate(final String creditCardExpiryDate) {		
	 _creditCardExpiryDate = creditCardExpiryDate;	
	}

	/**
	 * Accessor get
	 * @return creditCardExpiryDate
	 */
	public String getCreditCardExpiryDate() {		
		return _creditCardExpiryDate;
	}
/////-----Accessors param creditCardNumber-----/////
	/**
	 * Accessor set
	 * @param creditCardNumber
	 */
	public void setCreditCardNumber(final String creditCardNumber) {		
		_creditCardNumber = creditCardNumber;
	}
	/**
	 * Accessor get
	 * @return creditCardNumber
	 */
	public String getCreditCardNumber() {		
		return _creditCardNumber;
	}
	/////-----Acessors param creditCardType -----/////
	/**
	 * Accesor set
	 * @param creditCardType
	 */
	public void setCreditCardType(final String creditCardType) {
		_creditCardType = creditCardType;		
	}
	/**
	 * Accessor get
	 * @return creditCardType
	 */
	public String getCreditCardType() {
		return _creditCardType;
	}
	/////-----Accessor customerId-----/////
	/**
	 * Accesor set
	 * @param id
	 */
	public void setCustomerId(final String id) {
		_customerId = id;		
	}
	/**
	 * Accesor get
	 * @return
	 */
	public String getCustomerId() {		
		return _customerId;
	}
/////-----Accessors param firstname-----//////
	/**
	 * Accessor set
	 * @param firstname
	 */
	public void setFirstname(final String firstname) {
		_firstname = firstname;		
	}
	/**
	 * Accesor get
	 * @return firstname
	 */
	public String getFirstname() {
		return _firstname;
	}
/////-----Accessors param lastname-----/////
	/**
	 * Accessor set
	 * @param lastname
	 */
	public void setLastname(final String lastname) {
		_lastname =lastname;
	}
	/**
	 * Accessor get
	 * @return lastname
	 */
	public String getLastname() {		
		return _lastname;
	}	
/////-----Accessors param state-----/////
	/**
	 * Accesor set
	 * @param state
	 */
	public void setState(final String state) {
		_state = state;
	}
	/**
	 * Accessor get
	 * @return state
	 */
	public String getState() {		
		return _state;
	}
	/////-----Accessors param street1-----//////
	/**
	 * Accessor set
	 * @param street1
	 */
	public void setStreet1(final String street1) {
		_street1 =street1;
	}
	/**
	 * Accessor get
	 * @return street1
	 */
	public String getStreet1() {		
		return _street1;
	}
/////-----Accessors param street2-----/////
	/**
	 * Accessor set
	 * @param street2
	 */
	public void setStreet2(final String street2) {
		_street2 = street2;
	}
	/**
	 * Accessor get
	 * @return street2
	 */
	public String getStreet2() {		
		return _street2;
	}
	/////-----Accessors param zipcode-----/////
	/**
	 * Accessor set
	 * @param zipcode
	 */
	public void setZipcode(final String zipcode) {
		_zipcode =zipcode;
	}
	/**
	 * Accessor get
	 * @return
	 */
	public String getZipcode() {
		return _zipcode;
	}
	/////-----Accessors param date-----/////
	/**
	 * Accessor set
	 * @param date
	 */
	public void setOrderDate(final Date date) {
		_orderDate=date;
	}
	/**
	 * Accessor get
	 * @return orderDate
	 */
	public Date getOrderDate() {		
		return _orderDate;
	}
	/////-----Accessor param orderlines-----/////
	/**
	 * Accessor set
	 * @param _orderline
	 */
	public void setOrderLines(final Collection orderline) {
		_orderline = orderline;		
	}

	/**
	 * Accessor get
	 * @return _orderline
	 */
	public Collection getOrderLines() {
		return _orderline;
	}
	
	public String toString() {
	    final StringBuffer buf = new StringBuffer();
	    buf.append("\nCustomer {");
	    buf.append("\n\tId=").append(_id);
	    buf.append("\n\tFirstName=").append(_firstname);
	    buf.append("\n\tLastName=").append(_lastname);
	    buf.append("\n\tStreet1=").append(_street1);
	    buf.append("\n\tStreet2=").append(_street2);
	    buf.append("\n\tCountry=").append(_country);
	    buf.append("\n\tCity=").append(_city);	     	    
	    buf.append("\n\tState=").append(_state);	   	   
	    buf.append("\n\tZipCode=").append(_zipcode);
	    buf.append("\n\tCreditCardExpiryDate=").append(_creditCardExpiryDate);
	    buf.append("\n\tCreditCardNumber=").append(_creditCardNumber);
	    buf.append("\n\tCreditCardType=").append(_creditCardType);
	    buf.append("\n\tOrderDate=").append(_orderDate);
	    buf.append("\n\tOrderline=").append(_orderline);
	    buf.append("\n}");		    
	    return buf.toString();
	}
}
