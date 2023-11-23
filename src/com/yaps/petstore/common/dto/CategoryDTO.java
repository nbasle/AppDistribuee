/*
 * Created on 26 nov. 2005
 * CategoryDTO.java
 */
package com.yaps.petstore.common.dto;

/**
 * @author Veronique
 *
 */
public final class CategoryDTO implements DataTransfertObject {
	/////-----Attributes-----/////
	private String _id;
	private String _name;
	private String _description;
	
	/////-----Constructors-----/////
 public CategoryDTO() {
 	
 }
 public CategoryDTO(final String id, final String name, final String description) {
 	_id =id;
 	_name = name;
 	_description =description;
 	
 }
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
/**
 * Accessor set
 * @param name
 */
public void setName(final String name) {
	_name =name;
}
/**
 * Accessor get
 * @return name
 */
public String getName() {
	return _name;
}
/**
 * Accessor get
 * @param name
 */
public void setDescription(final String description) {
	_description = description;
}
/**
 * Accessor get
 * @return description
 */
public String getDescription() {
	return _description;
}
public String toString() {
    final StringBuffer buf = new StringBuffer();
    buf.append("\nCategory {");
    buf.append("\n\tId=").append(_id);
    buf.append("\n\tName=").append(_name);
    buf.append("\n\tDescription=").append(_description);    
    buf.append("\n}");
    return buf.toString();
}
}
