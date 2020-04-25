package com.indecomm.testing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TodoStatus {
	NEW(1),
	IN_PROGRESS(2),
	DONE(3);

	private final int statusCode;
}
