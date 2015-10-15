
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
public class ConverterPOATie extends ConverterPOA {
  private ConverterOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public ConverterPOATie (final ConverterOperations _delegate) {
    this._delegate = _delegate;
  }

  public ConverterPOATie (final ConverterOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public ConverterOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final ConverterOperations delegate) {
    this._delegate = delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

  /**
   * <pre>
   *   readonly attribute javax.ejb.Handle handle;
  #pragma original_getter_name handle "getHandle"
   * </pre>
   */
  public javax.ejb.Handle getHandle () throws java.rmi.RemoteException {
    return this._delegate.getHandle();
  }

  /**
   * <pre>
   *   readonly attribute javax.ejb.EJBHome EJBHome;
  #pragma original_getter_name EJBHome "getEJBHome"
   * </pre>
   */
  public javax.ejb.EJBHome getEJBHome () throws java.rmi.RemoteException {
    return this._delegate.getEJBHome();
  }

  /**
   * <pre>
   *   readonly attribute java.lang.Object primaryKey;
  #pragma original_getter_name primaryKey "getPrimaryKey"
   * </pre>
   */
  public java.lang.Object getPrimaryKey () throws java.rmi.RemoteException {
    return this._delegate.getPrimaryKey();
  }

  /**
   * <pre>
   *   void remove ()
    raises (javax.ejb.RemoveEx);
   * </pre>
   */
  public void remove () throws java.rmi.RemoteException,  javax.ejb.RemoveException {
    this._delegate.remove();
  }

  /**
   * <pre>
   *   boolean isIdentical (in javax.ejb.EJBObject arg0);
   * </pre>
   */
  public boolean isIdentical (javax.ejb.EJBObject arg0) throws java.rmi.RemoteException {
    return this._delegate.isIdentical(arg0);
  }

  /**
   * <pre>
   *   double dollarToYen (in double arg0);
   * </pre>
   */
  public double dollarToYen (double arg0) throws java.rmi.RemoteException {
    return this._delegate.dollarToYen(arg0);
  }

  /**
   * <pre>
   *   double yenToEuro (in double arg0);
   * </pre>
   */
  public double yenToEuro (double arg0) throws java.rmi.RemoteException {
    return this._delegate.yenToEuro(arg0);
  }

}
