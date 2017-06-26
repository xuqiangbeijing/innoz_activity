package com.clouderwork.innoz.common;

import java.util.List;

public class CommResult<T> {

	public int code;
	public String message;
	public List<T> content;

	public CommResult() {
		this.code = 0;
		this.message = "ok";
	}

	public CommResult(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public CommResult(int code, String message, List<T> content) {
		this.code = code;
		this.message = message;
		this.content = content;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
}