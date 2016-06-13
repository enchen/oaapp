package cn.exception;

public class OAException extends RuntimeException{

	/**
	 * OA系统基础异常
	 */
	private static final long serialVersionUID = -7058562478102797725L;

	public OAException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OAException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
