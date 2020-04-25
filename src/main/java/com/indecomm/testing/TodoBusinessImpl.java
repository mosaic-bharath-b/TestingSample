package com.indecomm.testing;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl implements TodoBusiness{

	//dependency
	TodoService todoService;

	// we need to test this
	public List<Todo> filterTodos(String text) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		List<Todo> todos = todoService.getTodos();

		for(Todo todo: todos) {
			if(todo.getName().contains(text)) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}
}
