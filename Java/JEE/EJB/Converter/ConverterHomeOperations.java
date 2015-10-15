/**
 * <ul>
 * <li> <b>IDL Source</b>    "reverse mapped from Java"
 * <li> <b>IDL Name</b>      ::ConverterHome
 * <li> <b>Repository Id</b> RMI:ConverterHome:0000000000000000
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ConverterHome : javax.ejb.EJBHome {
  ...
};
 * </pre>
 */
public interface ConverterHomeOperations extends javax.ejb.EJBHomeOperations {
  /**
   * <pre>
   *   Converter create ()
    raises (javax.ejb.CreateEx);
   * </pre>
   */
  public Converter create () throws java.rmi.RemoteException, javax.ejb.CreateException;

}
