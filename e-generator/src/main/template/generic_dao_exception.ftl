<#include "./common_t.ftl" />
package ${packageData.exceptionPackageName};

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
