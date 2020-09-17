package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("oid");
		Long customerId = resultSet.getLong("fk_cid");
		float orderTotal = resultSet.getFloat("order_total");
		Long itemId = resultSet.getLong("fk_iid");
		return new Order(id, customerId, orderTotal, itemId);
	}
	
	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select oid, fk_cid, fk_iid, order_total from orders, orderitems where orders.oid = orderitems.fk_oid;");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY oid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object. id will be ignored
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(fk_cid) values('" + order.getCustomerId()
					+ "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	//select fk_iid from orderitems where fk_oid = 2;
	// this will get all item ids associated with an order - use for read order
	//translates as: ; select fk_iid from orderitems where fk_oid =" + id
	public Order readOrder(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where oid = " + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in an order object, the id field will be used to
	 *                 update that order in the database
	 * @return
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			//put calc here
			//update orders set order_total = (select sum(price) from items, orderitems where iid = orderitems.fk_iid && orderitems.fk_oid = 1) where oid = 1;
			statement.executeUpdate("update orders set order_total = (select sum(price) from items, orderitems where iid = orderitems.fk_iid && orderitems.fk_oid =" + order.getId() +") where oid ="+ order.getId());
			return readOrder(order.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	//i dont know if this will work but i think the logic is there
	//PreparedStatement statement = connection.prepareStatement("INSERT INTO orderline (order_id, item_id) VALUES (?, ?)");

	public Order addToOrder(Long oid, Long iid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orderitems (`fk_oid`, `fk_iid`) VALUES (?, ?)");) {
			statement.setLong(1, oid);
			statement.setLong(2, iid);
			statement.executeUpdate();
			
			
			//this should be the correct way to insert it
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return readOrder(oid);
	}
	

	public Order delFromOrder(Long oid, Long iid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderitems where `fk_oid` = ? && `fk_iid`=?");) {
			statement.setLong(1, oid);
			statement.setLong(2, iid);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return readOrder(oid);
	}
	
	
	/**
	 * Calculates cost of an order in the database
	 * 
	 * @param order - takes in an order object, the id field will be used to
	 *                 calculate that order in the database
	 * @return
	 */
//	@Override
//	public Order calculate(Order order) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("update orders set fk_cid ='" + order.getCustomerId() + "' where oid =" + order.getId());
//			return readOrder(order.getId());
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
	/**
	 * Deletes an order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from orders where oid = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}
