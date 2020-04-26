package com.indecomm.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplAdvancedTest {

	List<Todo> todos = Arrays.asList(
			new Todo("Prepare for exam",LocalDate.of(2020, 04, 26), TodoStatus.NEW),
			new Todo("Get milk",LocalDate.of(2020, 04, 26), TodoStatus.NEW),
			new Todo("Call mom",LocalDate.of(2020, 04, 26), TodoStatus.NEW)
	);

	@Mock
	TodoService mockTodoService;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testScores() {
  	List<Integer> scores = Arrays.asList(10, 99, 100, 36);

  	assertThat(scores, hasItems(100));
  	assertThat(scores, everyItem(greaterThan(1)));
	  assertThat("", isEmptyString());
  }

  @Test
  public void filterTodos_mockingTodoService() {
  	//Given
  	given(mockTodoService.getTodos()).willReturn(todos);

  	//When
	  List<Todo> todos = todoBusinessImpl.filterTodos("mom");
	  List<Todo> filtered = Arrays.asList(new Todo("Call mom",LocalDate.of(2020, 04, 26), TodoStatus.NEW));

  	//Then
  	assertEquals(filtered,todos);
  }

	@Test
	public void deleteTodo_mockingTodoService() {
		//Given
		given(mockTodoService.getTodos()).willReturn(todos);

		//When
		todoBusinessImpl.deleteTodoIfNotEmpty("mom");

		//Then
		then(mockTodoService).should().deleleTodo("mom");
	}

	@Test
	public void deleteTodo_IsNotCalled() {
		//Given
		given(mockTodoService.getTodos()).willReturn(todos);

		//When
		todoBusinessImpl.deleteTodoIfNotEmpty("");

		//Then
		then(mockTodoService).should(never()).deleleTodo("mom");
	}
}
