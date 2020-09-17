package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "rootroot");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(2L, "Donkey", 300);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, "jordans", 200));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, "jordans", 200), DAO.readLatest());
	}

	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, "jordans", 200), DAO.readOrder(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, "jordans", 250);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
