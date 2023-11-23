package com.yaps.petstore.server.domain.category;

import com.yaps.petstore.common.exception.CheckException;
import com.yaps.petstore.server.domain.PersistentObject;

import java.util.Collection;

/**
 * This class represents a Category in the catalog of the YAPS company.
 * The catalog is divided into catagories. Each one divided into products
 * and each product in items.
 */
public final class Category extends PersistentObject {

    // ======================================
    // =             Attributes             =
    // ======================================
    private String _name;
    private String _description;
    private Collection _products;

    // ======================================
    // =            Constructors            =
    // ======================================
    {
        _dao = new CategoryDAO();
    }

    public Category() {
    }

    public Category(final String id) {
        _id = id;
    }

    public Category(final String id, final String name, final String description) {
        _id = id;
        _name = name;
        _description = description;
    }

    // ======================================
    // =          Protected methods         =
    // ======================================
    protected void loadObject(final Object object) {
        final Category temp = (Category) object;

        // Sets data to current object
        _id = temp.getId();
        _name = temp.getName();
        _description = temp.getDescription();
        _products = temp.getProducts();
    }

    protected void checkData() throws CheckException {
        checkId(_id);
        if (_name == null || "".equals(_name))
            throw new CheckException("Invalid name");
        if (_description == null || "".equals(_description))
            throw new CheckException("Invalid description");
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    public String getName() {
        return _name;
    }

    public void setName(final String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(final String description) {
        _description = description;
    }

    public Collection getProducts() {
        return _products;
    }

    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("Category{");
        buf.append("id=").append(_id);
        buf.append(",name=").append(_name);
        buf.append(",description=").append(_description);
        buf.append('}');
        return buf.toString();
    }
}
