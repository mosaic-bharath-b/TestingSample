package com.indecomm.testing;

import lombok.Value;
import java.time.LocalDate;

@Value
public class Todo {
	private String name;
	private LocalDate date;
	private TodoStatus status;
}
