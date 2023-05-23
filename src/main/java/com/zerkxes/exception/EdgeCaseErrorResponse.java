package com.zerkxes.exception;

public class EdgeCaseErrorResponse {

	private int status;
	private String message;
	private StackTraceElement trace;
	private long timestamp;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StackTraceElement getTrace() {
		return trace;
	}

	public void setTrace(StackTraceElement trace) {
		this.trace = trace;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public EdgeCaseErrorResponse(int status, String message, StackTraceElement trace, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.trace = trace;
		this.timestamp = timestamp;
	}

}
