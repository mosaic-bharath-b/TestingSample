package com.indecomm.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class TodoTest {

	Todo todo;

  @Before
  public void setUp() throws Exception {
  	todo = new Todo("Fill a form", LocalDate.of(2020, 04, 25), TodoStatus.NEW);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getName() {
  	assertEquals("Fill a form", todo.getName());
  }

  @Test
  public void getDate() {
  	assertEquals(LocalDate.of(2020, 04, 25), todo.getDate());
  }

  @Test
  public void getStatus() {
  	assertEquals(TodoStatus.NEW, todo.getStatus());
  }
}
