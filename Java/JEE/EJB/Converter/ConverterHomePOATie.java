
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
public class ConverterHomePOATie extends ConverterHomePOA {
  private ConverterHomeOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public ConverterHomePOATie (final ConverterHomeOperations _delegate) {
    this._delegate = _delegate;
  }

  public ConverterHomePOATie (final ConverterHomeOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public ConverterHomeOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final ConverterHomeOperations delegate) {
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
   *   readonly attribute javax.ejb.EJBMetaData EJBMetaData;
  #pragma original_getter_name EJBMetaData "getEJBMetaData"
   * </pre>
   */
  public javax.ejb.EJBMetaData getEJBMetaData () throws java.rmi.RemoteException {
    return this._delegate.getEJBMetaData();
  }

  /**
   * <pre>
   *   readonly attribute javax.ejb.HomeHandle homeHandle;
  #pragma original_getter_name homeHandle "getHomeHandle"
   * </pre>
   */
  public javax.ejb.HomeHandle getHomeHandle () throws java.rmi.RemoteException {
    return this._delegate.getHomeHandle();
  }

  /**
   * <pre>
   *   void remove__java_lang_Object (in java.lang.Object arg0)
    raises (javax.ejb.RemoveEx);
  #pragma original_name remove__java_lang_Object "remove"
   * </pre>
   */
  public void remove (java.lang.Object arg0) throws java.rmi.RemoteException,  javax.ejb.RemoveException {
    this._delegate.remove(arg0);
  }

  /**
   * <pre>
   *   void remove__javax_ejb_Handle (in javax.ejb.Handle arg0)
    raises (javax.ejb.RemoveEx);
  #pragma original_name remove__javax_ejb_Handle "remove"
   * </pre>
   */
  public void remove (javax.ejb.Handle arg0) throws java.rmi.RemoteException,  javax.ejb.RemoveException {
    this._delegate.remove(arg0);
  }

  /**
   * <pre>
   *   Converter create ()
    raises (javax.ejb.CreateEx);
   * </pre>
   */
  public Converter create () throws java.rmi.RemoteException,  javax.ejb.CreateException {
    return this._delegate.create();
  }

}
