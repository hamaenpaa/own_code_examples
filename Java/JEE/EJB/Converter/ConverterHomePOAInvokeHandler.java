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
public class ConverterHomePOAInvokeHandler extends ConverterHomePOA {
  private com.inprise.vbroker.rmi.CORBA.InvocationTarget _target;
  private static java.lang.reflect.Method _MethodPtrs[];
  private static void initMethodPointers () {
    try {
      _MethodPtrs = new java.lang.reflect.Method[] {
        ConverterHome.class.getDeclaredMethod("create", new Class[]{}),
      };
    }
    catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }
  static {initMethodPointers();}

  public ConverterHomePOAInvokeHandler (final com.inprise.vbroker.rmi.CORBA.InvocationTarget target) {
    this._target = target;
  }

  public com.inprise.vbroker.rmi.CORBA.InvocationTarget target () {
    return this._target;
  }

  public void target (final com.inprise.vbroker.rmi.CORBA.InvocationTarget target) {
    this._target = target;
  }

  /**
   * <pre>
   *   Converter create ()
    raises (javax.ejb.CreateEx);
   * </pre>
   */
  public static Converter create (com.inprise.vbroker.rmi.CORBA.InvocationTarget _target)
    throws java.rmi.RemoteException, javax.ejb.CreateException {
    java.lang.Object[] _args = {};
    try {
      java.lang.Object _result = _target.invoke(_MethodPtrs[0], _args);
      return (Converter)_result;
    }
    catch (java.lang.reflect.InvocationTargetException ite) {
      final java.lang.Throwable t = ite.getTargetException();
      if (t instanceof javax.ejb.CreateException) {
        throw (javax.ejb.CreateException)t;
      }
      if (t instanceof java.rmi.RemoteException) {
        throw (java.rmi.RemoteException)t;
      }
      throw new org.omg.CORBA.UNKNOWN(t.getMessage());
    }
  }

  /**
   * <pre>
   *   readonly attribute javax.ejb.EJBMetaData EJBMetaData;
  #pragma original_getter_name EJBMetaData "getEJBMetaData"
   * </pre>
   */
  public javax.ejb.EJBMetaData getEJBMetaData ()
    throws java.rmi.RemoteException {
    return javax.ejb.EJBHomePOAInvokeHandler.getEJBMetaData(_target);
  }
  /**
   * <pre>
   *   readonly attribute javax.ejb.HomeHandle homeHandle;
  #pragma original_getter_name homeHandle "getHomeHandle"
   * </pre>
   */
  public javax.ejb.HomeHandle getHomeHandle ()
    throws java.rmi.RemoteException {
    return javax.ejb.EJBHomePOAInvokeHandler.getHomeHandle(_target);
  }
  /**
   * <pre>
   *   void remove__java_lang_Object (in java.lang.Object arg0)
    raises (javax.ejb.RemoveEx);
  #pragma original_name remove__java_lang_Object "remove"
   * </pre>
   */
  public void remove (java.lang.Object arg0)
    throws java.rmi.RemoteException, javax.ejb.RemoveException {
    javax.ejb.EJBHomePOAInvokeHandler.remove(_target, arg0);
  }
  /**
   * <pre>
   *   void remove__javax_ejb_Handle (in javax.ejb.Handle arg0)
    raises (javax.ejb.RemoveEx);
  #pragma original_name remove__javax_ejb_Handle "remove"
   * </pre>
   */
  public void remove (javax.ejb.Handle arg0)
    throws java.rmi.RemoteException, javax.ejb.RemoveException {
    javax.ejb.EJBHomePOAInvokeHandler.remove(_target, arg0);
  }
  /**
   * <pre>
   *   Converter create ()
    raises (javax.ejb.CreateEx);
   * </pre>
   */
  public Converter create ()
    throws java.rmi.RemoteException, javax.ejb.CreateException {
    return ConverterHomePOAInvokeHandler.create(_target);
  }
}
