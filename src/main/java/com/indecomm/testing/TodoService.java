package com.indecomm.testing;

import java.util.List;

public interface TodoService {
	public List<Todo> getTodos();

	public void deleleTodo(String text);
}
