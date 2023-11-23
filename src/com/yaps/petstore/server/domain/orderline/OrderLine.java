package com.yaps.petstore.server.domain.orderline;

import com.yaps.petstore.common.exception.CheckException;
import com.yaps.petstore.common.exception.CreateException;
import com.yaps.petstore.common.exception.FinderException;
import com.yaps.petstore.common.exception.ObjectNotFoundException;
import com.yaps.petstore.common.logging.Trace;
import com.yaps.petstore.server.domain.PersistentObject;
import com.yaps.petstore.server.domain.item.Item;
import com.yaps.petstore.server.domain.order.Order;

import java.util.Collection;
import java.util.Iterator;

/**
 * An Order has several order lines. This class represent one order line.
 */
public final class OrderLine extends PersistentObject {

    // ======================================
    // =             Attributes             =
    // ======================================
    private int _quantity;
    private double _unitCost;
    private Item _item;
    private Order _order;

    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "OrderLine";

    // ======================================
    // =            Constructors            =
    // ======================================
    {
        _dao = new OrderLineDAO();
    }

    public OrderLine() {
    }

    public OrderLine(final String id) {
        _id = id;
    }

    public OrderLine(final String id, final int quantity, final double unitCost, final Order order, final Item item) {
        _id = id;
        _quantity = quantity;
        _unitCost = unitCost;
        _order = order;
        _item = item;
    }

    public OrderLine(final int quantity, final double unitCost, final Order order, final Item item) {
        _quantity = quantity;
        _unitCost = unitCost;
        _order = order;
        _item = item;
    }

    // ======================================
    // =           Business methods         =
    // ======================================
    public PersistentObject create() throws CreateException, CheckException {
        final String mname = "create";
        Trace.entering(_cname, mname);

        // Gets a unique id and the current date
        _id = getUniqueId(COUNTER_NAME);

        // Checks data integrity
        checkData();

        // Uses the DAO to access the persistent layer
        _dao.insert(this);

        return this;
    }

    /**
     * This methods returns all the order lines for a given order with its item.
     *
     * @param orderId order id from which we want all the items
     * @return a collection of OrderLine
     * @throws ObjectNotFoundException thrown if the id is not found
     * @throws FinderException         thrown if a system failure occurs
     */
    public Collection findAll(final String orderId) throws FinderException {
        final String mname = "findAll";
        Trace.entering(_cname, mname, orderId);

        final Collection orderLines;

        orderLines = ((OrderLineDAO)_dao).selectAll(orderId);
        for (Iterator iterator = orderLines.iterator(); iterator.hasNext();) {
            final OrderLine orderLine = (OrderLine) iterator.next();
            try {
                // Gets all the data of the Item
                orderLine.getItem().findByPrimaryKey(orderLine.getItem().getId());
            } catch (CheckException e) {
                throw new FinderException("Cannot get the item");
            }
        }

        Trace.exiting(_cname, mname, new Integer(orderLines.size()));
        return orderLines;
    }

    // ======================================
    // =          Protected methods         =
    // ======================================
    protected void loadObject(final Object object) {
        final OrderLine temp = (OrderLine) object;

        // Sets data to current object
        _id = temp.getId();
        _quantity = temp.getQuantity();
        _item = temp.getItem();
    }

    protected void checkData() throws CheckException {
        checkId(_id);
        if (_unitCost <= 0)
            throw new CheckException("Invalid unit cost");
        if (_quantity <= 0)
            throw new CheckException("Invalid quantity");
        if (_order == null)
            throw new CheckException("Invalid order");
        if (_item == null)
            throw new CheckException("Invalid item");
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(final int quantity) {
        _quantity = quantity;
    }

    public double getUnitCost() {
        return _unitCost;
    }

    public void setUnitCost(final double unitCost) {
        _unitCost = unitCost;
    }

    public Order getOrder() {
        return _order;
    }

    public void setOrder(final Order order) {
        _order = order;
    }

    public Item getItem() {
        return _item;
    }

    public void setItem(final Item item) {
        _item = item;
    }

    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("OrderLine{");
        buf.append("id=").append(_id);
        buf.append(",quantity=").append(_quantity);
        buf.append(",unitCost=").append(_unitCost);
        buf.append('}');
        return buf.toString();
    }
}
