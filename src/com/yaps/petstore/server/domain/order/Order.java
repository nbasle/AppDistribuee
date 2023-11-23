package com.yaps.petstore.server.domain.order;

import com.yaps.petstore.common.exception.CheckException;
import com.yaps.petstore.common.exception.CreateException;
import com.yaps.petstore.common.logging.Trace;
import com.yaps.petstore.server.domain.PersistentObject;
import com.yaps.petstore.server.domain.customer.Customer;

import java.util.Collection;
import java.util.Date;

/**
 * An order represents the items that a customer buys. This order has several
 * order items and is relevant for one customer. The order has address information
 * like the street, the city, the country... This is because a customer can order
 * a pet and wants it delivered at another adress. By default, the order address
 * is the same that the customer's one but it can be changed.
 *
 * @see Customer
 */
public final class Order extends PersistentObject {

    // ======================================
    // =             Attributes             =
    // ======================================
    private Date _orderDate;
    private String _firstname;
    private String _lastname;
    private String _street1;
    private String _street2;
    private String _city;
    private String _state;
    private String _zipcode;
    private String _country;
    private String _creditCardNumber;
    private String _creditCardType;
    private String _creditCardExpiryDate;
    private Customer _customer;
    private Collection _orderLines;

    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "Order";

    // ======================================
    // =            Constructors            =
    // ======================================
    {
        _dao = new OrderDAO();
    }

    public Order() {
    }

    public Order(final String id) {
        _id = id;
    }

    public Order(final String id, final Date orderDate, final String firstname, final String lastname, final String street1, final String city, final String zipcode, final String country, final Customer customer) {
        _id = id;
        _orderDate = orderDate;
        _firstname = firstname;
        _lastname = lastname;
        _street1 = street1;
        _city = city;
        _zipcode = zipcode;
        _country = country;
        _customer = customer;
    }

    public Order(final String firstname, final String lastname, final String street1, final String city, final String zipcode, final String country, final Customer customer) {
        _firstname = firstname;
        _lastname = lastname;
        _street1 = street1;
        _city = city;
        _zipcode = zipcode;
        _country = country;
        _customer = customer;
    }

    // ======================================
    // =           Business methods         =
    // ======================================
    public PersistentObject create() throws CreateException, CheckException {
        final String mname = "create";
        Trace.entering(_cname, mname);

        // Gets a unique id and the current date
        _id = getUniqueId(COUNTER_NAME);
        _orderDate = new Date();

        // Checks data integrity
            checkData();

        // Uses the DAO to access the persistent layer
        _dao.insert(this);

        return this;
    }

    // ======================================
    // =          Protected methods         =
    // ======================================
    protected void loadObject(final Object object) {
        final Order temp = (Order) object;

        // Sets data to current object
        _id = temp.getId();
        _firstname = temp.getFirstname();
        _lastname = temp.getLastname();
        _city = temp.getCity();
        _country = temp.getCountry();
        _creditCardExpiryDate = temp.getCreditCardExpiryDate();
        _creditCardNumber = temp.getCreditCardNumber();
        _creditCardType = temp.getCreditCardType();
        _customer = temp.getCustomer();
        _orderDate = temp.getOrderDate();
        _state = temp.getState();
        _street1 = temp.getStreet1();
        _street2 = temp.getStreet2();
        _zipcode = temp.getZipcode();
    }

    protected void checkData() throws CheckException {
        checkId(_id);
        if (_firstname == null || "".equals(_firstname))
            throw new CheckException("Invalid first name");
        if (_lastname == null || "".equals(_lastname))
            throw new CheckException("Invalid last name");
        if (_city == null || "".equals(_city))
            throw new CheckException("Invalid city");
        if (_country == null || "".equals(_country))
            throw new CheckException("Invalid country");
        if (_street1 == null || "".equals(_street1))
            throw new CheckException("Invalid street");
        if (_zipcode == null || "".equals(_zipcode))
            throw new CheckException("Invalid zipcode");
        if (_customer == null)
            throw new CheckException("Invalid customer");
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    public Date getOrderDate() {
        return _orderDate;
    }

    public String getFirstname() {
        return _firstname;
    }

    public void setFirstname(final String firstname) {
        _firstname = firstname;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(final String lastname) {
        _lastname = lastname;
    }

    public String getStreet1() {
        return _street1;
    }

    public void setStreet1(final String street1) {
        _street1 = street1;
    }

    public String getStreet2() {
        return _street2;
    }

    public void setStreet2(final String street2) {
        _street2 = street2;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(final String city) {
        _city = city;
    }

    public String getState() {
        return _state;
    }

    public void setState(final String state) {
        _state = state;
    }

    public String getZipcode() {
        return _zipcode;
    }

    public void setZipcode(final String zipcode) {
        _zipcode = zipcode;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(final String country) {
        _country = country;
    }

    public String getCreditCardNumber() {
        return _creditCardNumber;
    }

    public void setCreditCardNumber(final String creditCardNumber) {
        _creditCardNumber = creditCardNumber;
    }

    public String getCreditCardType() {
        return _creditCardType;
    }

    public void setCreditCardType(final String creditCardType) {
        _creditCardType = creditCardType;
    }

    public String getCreditCardExpiryDate() {
        return _creditCardExpiryDate;
    }

    public void setCreditCardExpiryDate(final String creditCardExpiryDate) {
        _creditCardExpiryDate = creditCardExpiryDate;
    }

    public Customer getCustomer() {
        return _customer;
    }

    public void setCustomer(final Customer customer) {
        _customer = customer;
    }

    public Collection getOrderLines() {
        return _orderLines;
    }

    public void setOrderLines(final Collection orderLines) {
        _orderLines = orderLines;
    }

    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("Order{");
        buf.append("id=").append(_id);
        buf.append(",orderDate=").append(_orderDate);
        buf.append(",firstname=").append(_firstname);
        buf.append(",lastname=").append(_lastname);
        buf.append(",street1=").append(_street1);
        buf.append(",street2=").append(_street2);
        buf.append(",city=").append(_city);
        buf.append(",state=").append(_state);
        buf.append(",zipcode=").append(_zipcode);
        buf.append(",country=").append(_country);
        buf.append(",creditCardNumber=").append(_creditCardNumber);
        buf.append(",creditCardType=").append(_creditCardType);
        buf.append(",creditCardExpiryDate=").append(_creditCardExpiryDate);
        buf.append('}');
        return buf.toString();
    }
}
