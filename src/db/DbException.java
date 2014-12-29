package db;

public class DbException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DbException(){
		super();
	}
	
	public DbException(String message, Throwable exeption){
		super(message, exeption);
	}
	
	public DbException(String message){
		super(message);
	}
	
	public DbException(Throwable exeption){
		super(exeption);
	}
}
