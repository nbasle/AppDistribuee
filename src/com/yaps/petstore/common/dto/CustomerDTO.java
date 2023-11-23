/*
 * Created on 26 nov. 2005
 *
 * CustomerDTO
 */
package com.yaps.petstore.common.dto;

/**
 * @author Veronique
 *
 * CustomerDTO
 */
public final class CustomerDTO implements DataTransfertObject {
	
	//Attributes
	private String _id;
	private String _city;
	private String _country;
	private String _firstname;
	private String _lastname;
	private String _state;
	private String _street1;
	private String _street2;
	private String _telephone;
	private String _zipcode;
	
	/////Constructors/////
	public CustomerDTO() {
		
	}
	
	/////-------------------------------------/////
	/////      Accessors set & get			  /////
	/////-------------------------------------/////

	/**
	 * @param customerid
	 * @param firstname
	 * @param lastname
	 */
	public CustomerDTO(final String customerId, final String firstname, final String lastname) {
		
		_id = customerId;
		_firstname = firstname;
		_lastname = lastname;
	}

	/////---Accessors ----- Parameter id -----/////
	/**
	 * Accessor set
	 * @param id
	 */
	public void setId(final String id) {
		_id =id;	
	}
	/**
	 * Accessor get
	 * @return id
	 */
	public String getId() {
		
		return _id;
	}
/////---Accessors ----- Parameter city -----/////
	/**
	 * Accessor set
	 * @param city
	 */
	public void setCity(final String city) {
		_city =city;
	}
	/**
	 * Accessor get
	 * @return city
	 */
	public String getCity() {
		return _city;
	}
/////---Accessors ----- Parameter country -----/////
	/**
	 * Accessor set
	 * @param country
	 */
	public void setCountry(final String country) {
		_country = country;
	}
	/**
	 * Accessor get
	 * @return countru
	 */
	public String getCountry() {
		return _country;
	}
/////---Accessors ----- Parameter firstname -----/////
	/**
	 * Accessor set
	 * @param firstname
	 */
	public void setFirstname(final String firstname) {
		_firstname = firstname;
	}
	/**
	 * Accessor get
	 * @return firstname
	 */
	public String getFirstname() {
		return _firstname;
	}
/////---Accessors ----- Parameter lastname -----/////
	/**
	 * Accessor set
	 * @param lastname
	 */
	public void setLastname(final String lastname) {
		_lastname = lastname;
	}
	/**
	 * Accesor get
	 * @return lastname
	 */
	public String getLastname() {
		return _lastname;
	}
/////---Accessors ----- Parameter state -----/////
	/**
	 * Accessor set
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
/////---Accessors ----- Parameter street1 -----/////
	/**
	 * Accessor set
	 * @param street1
	 */
	public void setStreet1(final String street1) {
		_street1 = street1;
	}
	/**
	 * Accesor get
	 * @return street1
	 */
	public String getStreet1() {
		return _street1;
	}
/////---Accessors ----- Parameter street2 -----/////
	/**
	 * Accesor set
	 * @param street2
	 */
	public void setStreet2(final String street2) {
		_street2=street2;
	}
	/**
	 * Accessor get
	 * @return street2
	 */
	public String getStreet2() {
		return _street2;
	}
/////---Accessors ----- Parameter telephone -----/////
	/**
	 * Accessor set
	 * @param telephone
	 */
	public void setTelephone(final String telephone) {
		_telephone = telephone;
	}
	/**
	 * Accesor get
	 * @return telephone
	 */
	public String getTelephone() {
		return _telephone;
	}
/////---Accessors ----- Parameter zipcode -----/////
	/**
	 * Accesor set
	 * @param zipcode
	 */
	public void setZipcode(final String zipcode) {
		_zipcode = zipcode;
	}
	/**
	 * Accessor get
	 * @return zipcode
	 */
	public String getZipcode() {
		return _zipcode;
	}
	public String toString() {
	    final StringBuffer buf = new StringBuffer();
	    buf.append("\nCustomer {");
	    buf.append("\n\tId=").append(_id);
	    buf.append("\n\tCity=").append(_city);
	    buf.append("\n\tCountry=").append(_country); 
	    buf.append("\n\tFirstName=").append(_firstname);
	    buf.append("\n\tLastName=").append(_lastname);
	    buf.append("\n\tState=").append(_state);
	    buf.append("\n\tStreet1=").append(_street1);
	    buf.append("\n\tStreet2=").append(_street2);
	    buf.append("\n\tTelephone=").append(_telephone);
	    buf.append("\n\tZipCode=").append(_zipcode);
	    buf.append("\n}");	   
	    return buf.toString();
	}

}
