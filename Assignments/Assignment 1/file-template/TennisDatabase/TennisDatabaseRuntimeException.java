package TennisDatabase;

// Custom (unchecked) exception for the TennisDatabase package, representing non critical runtime errors (handling is optional).
public class TennisDatabaseRuntimeException extends java.lang.RuntimeException {
   
   // Desc.: Constructor.
   // Input: Description of the runtime error.
   public TennisDatabaseRuntimeException( String s ) { super(s); }
   
}
