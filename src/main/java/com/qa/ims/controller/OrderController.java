package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;


	/**
	 * Takes in order details for CRUD functionality
	 *
	 */
public class OrderController implements CrudController<Order> {

		public static final Logger LOGGER = LogManager.getLogger();

		private OrderDAO orderDAO;
		private Utils utils;

		public OrderController(OrderDAO orderDAO, Utils utils) {
			super();
			this.orderDAO = orderDAO;
			this.utils = utils;
		}

		/**
		 * Reads all orders to the logger
		 */
		@Override
		public List<Order> readAll() {
			List<Order> orders = orderDAO.readAll();
			for (Order order : orders) {
				LOGGER.info(order.toString());
			}
			return orders;
		}

		/**
		 * Creates an order by taking in user input
		 */
		@Override
		public Order create() {
			LOGGER.info("Please enter a customer id");
			Long customerId = utils.getLong();
			LOGGER.info("Please enter an item id");
			Long itemId = utils.getLong();
			Order order = orderDAO.create(new Order(customerId, itemId));
			LOGGER.info("Order created");
			return order;
		}

		/**
		 * Updates an existing order by taking in user input
		 */
		@Override
		public Order update() {
			Order order = null;
			LOGGER.info("Please enter the id of the order you would like to update");
			Long id = utils.getLong();
			LOGGER.info("Would you like to ADDTO or DELFROM this order?");
			String orderInput = utils.getString();
			if (orderInput.equalsIgnoreCase("ADDTO")) {
				LOGGER.info("Enter the itemID of the item you wish to add");
				Long iid = utils.getLong();
				order = orderDAO.addToOrder(id, iid);
				
			} else if (orderInput.equalsIgnoreCase("DELFROM")) {
				LOGGER.info("Enter the itemID of the item you wish to delete");
				Long iid = utils.getLong();
				order = orderDAO.delFromOrder(id, iid);
				
			} else {
				LOGGER.error("Invalid selection please try again");
			}
			
			//Long customerId = utils.getLong();
			//LOGGER.info("Please enter an item id");
			//Long itemId = utils.getLong();
			order = orderDAO.update(new Order(id));
			LOGGER.info("Order Updated");
			return order;
		}
		
//		public Order addToOrder() {
//			
//		}
//		
		/**
		 * calculates total of an existing order by taking in user input
		 */
//		@Override
//		public Order calculate() {
//			LOGGER.info("Please enter the id of the order you would like to calculate");
//			Long id = utils.getLong();
//			
//			Order order = orderDAO.update(new Order(id, customerId, itemId));
//			LOGGER.info("Order Updated");
//			return order;
//		}

		/**
		 * Deletes an existing order by the id of the customer
		 * 
		 * @return
		 */
		@Override
		public int delete() {
			LOGGER.info("Please enter the id of the order you would like to delete");
			Long id = utils.getLong();
			return orderDAO.delete(id);
		}

}
