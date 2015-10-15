/**
 * <ul>
 * <li> <b>IDL Source</b>    "reverse mapped from Java"
 * <li> <b>IDL Name</b>      ::Converter
 * <li> <b>Repository Id</b> RMI:Converter:0000000000000000
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface Converter : javax.ejb.EJBObject {
  ...
};
 * </pre>
 */
public interface ConverterOperations extends javax.ejb.EJBObjectOperations {
  /**
   * <pre>
   *   double dollarToYen (in double arg0);
   * </pre>
   */
  public double dollarToYen (double arg0) throws java.rmi.RemoteException;

  /**
   * <pre>
   *   double yenToEuro (in double arg0);
   * </pre>
   */
  public double yenToEuro (double arg0) throws java.rmi.RemoteException;

}
