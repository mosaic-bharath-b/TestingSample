package com.indecomm.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplTest {

	List<Todo> todos = Arrays.asList(
			new Todo("Prepare for exam",LocalDate.of(2020, 04, 26), TodoStatus.NEW),
			new Todo("Get milk",LocalDate.of(2020, 04, 26), TodoStatus.NEW),
			new Todo("Call mom",LocalDate.of(2020, 04, 26), TodoStatus.NEW)
	);

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void filterTodos_mockingTodoService() {
  	//Given
  	TodoService todoService = mock(TodoService.class);
  	TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

  	when(todoService.getTodos()).thenReturn(todos);

  	//When
  	List<Todo> filtered = Arrays.asList(new Todo("Call mom",LocalDate.of(2020, 04, 26), TodoStatus.NEW));

  	//Then
  	assertEquals(filtered, todoBusiness.filterTodos("mom"));
  }

	@Test
	public void filterTodos_WhenEmptyStringIsPassed() {
		//Given
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
		given(todoService.getTodos()).willReturn(todos);

		//When
		List<Todo> expected = todos;
		List<Todo> actual = todoBusiness.filterTodos("");

		//Then
		assertEquals(expected, actual);
	}

	@Test
	public void filterTodos_WhenEmptyStringIsPassedWithAssertThat() {
		//Given
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
		given(todoService.getTodos()).willReturn(todos);

		//When
		List<Todo> expected = todos;
		List<Todo> actual = todoBusiness.filterTodos("");

		//Then
		assertThat(actual.size(), is(equalTo(3)));
		assertThat(actual, is(expected));
	}
}
