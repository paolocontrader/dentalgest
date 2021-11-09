package toDo;

public class EmptyToDoException extends Exception{
    	// no-argument constructor specifies default error message
		public EmptyToDoException() {
			super("Inserire nome prestazione");
		}

		// constructor to allow customized error message
		public EmptyToDoException(String message) {
			super(message);
		}
}
