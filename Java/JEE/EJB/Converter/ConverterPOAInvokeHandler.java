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
public class ConverterPOAInvokeHandler extends ConverterPOA {
  private com.inprise.vbroker.rmi.CORBA.InvocationTarget _target;
  private static java.lang.reflect.Method _MethodPtrs[];
  private static void initMethodPointers () {
    try {
      _MethodPtrs = new java.lang.reflect.Method[] {
        Converter.class.getDeclaredMethod("dollarToYen", new Class[]{java.lang.Double.TYPE}),
        Converter.class.getDeclaredMethod("yenToEuro", new Class[]{java.lang.Double.TYPE}),
      };
    }
    catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }
  static {initMethodPointers();}

  public ConverterPOAInvokeHandler (final com.inprise.vbroker.rmi.CORBA.InvocationTarget target) {
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
   *   double dollarToYen (in double arg0);
   * </pre>
   */
  public static double dollarToYen (com.inprise.vbroker.rmi.CORBA.InvocationTarget _target,
                                    double arg0)
    throws java.rmi.RemoteException {
    java.lang.Object[] _args = {new java.lang.Double(arg0)};
    try {
      java.lang.Object _result = _target.invoke(_MethodPtrs[0], _args);
      return ((java.lang.Double)_result).doubleValue();
    }
    catch (java.lang.reflect.InvocationTargetException ite) {
      final java.lang.Throwable t = ite.getTargetException();
      if (t instanceof java.rmi.RemoteException) {
        throw (java.rmi.RemoteException)t;
      }
      throw new org.omg.CORBA.UNKNOWN(t.getMessage());
    }
  }
  /**
   * <pre>
   *   double yenToEuro (in double arg0);
   * </pre>
   */
  public static double yenToEuro (com.inprise.vbroker.rmi.CORBA.InvocationTarget _target,
                                  double arg0)
    throws java.rmi.RemoteException {
    java.lang.Object[] _args = {new java.lang.Double(arg0)};
    try {
      java.lang.Object _result = _target.invoke(_MethodPtrs[1], _args);
      return ((java.lang.Double)_result).doubleValue();
    }
    catch (java.lang.reflect.InvocationTargetException ite) {
      final java.lang.Throwable t = ite.getTargetException();
      if (t instanceof java.rmi.RemoteException) {
        throw (java.rmi.RemoteException)t;
      }
      throw new org.omg.CORBA.UNKNOWN(t.getMessage());
    }
  }

  /**
   * <pre>
   *   readonly attribute javax.ejb.Handle handle;
  #pragma original_getter_name handle "getHandle"
   * </pre>
   */
  public javax.ejb.Handle getHandle ()
    throws java.rmi.RemoteException {
    return javax.ejb.EJBObjectPOAInvokeHandler.getHandle(_target);
  }
  /**
   * <pre>
   *   readonly attribute javax.ejb.EJBHome EJBHome;
  #pragma original_getter_name EJBHome "getEJBHome"
   * </pre>
   */
  public javax.ejb.EJBHome getEJBHome ()
    throws java.rmi.RemoteException {
    return javax.ejb.EJBObjectPOAInvokeHandler.getEJBHome(_target);
  }
  /**
   * <pre>
   *   readonly attribute java.lang.Object primaryKey;
  #pragma original_getter_name primaryKey "getPrimaryKey"
   * </pre>
   */
  public java.lang.Object getPrimaryKey ()
    throws java.rmi.RemoteException {
    return javax.ejb.EJBObjectPOAInvokeHandler.getPrimaryKey(_target);
  }
  /**
   * <pre>
   *   void remove ()
    raises (javax.ejb.RemoveEx);
   * </pre>
   */
  public void remove ()
    throws java.rmi.RemoteException, javax.ejb.RemoveException {
    javax.ejb.EJBObjectPOAInvokeHandler.remove(_target);
  }
  /**
   * <pre>
   *   boolean isIdentical (in javax.ejb.EJBObject arg0);
   * </pre>
   */
  public boolean isIdentical (javax.ejb.EJBObject arg0)
    throws java.rmi.RemoteException {
    return javax.ejb.EJBObjectPOAInvokeHandler.isIdentical(_target, arg0);
  }
  /**
   * <pre>
   *   double dollarToYen (in double arg0);
   * </pre>
   */
  public double dollarToYen (double arg0)
    throws java.rmi.RemoteException {
    return ConverterPOAInvokeHandler.dollarToYen(_target, arg0);
  }
  /**
   * <pre>
   *   double yenToEuro (in double arg0);
   * </pre>
   */
  public double yenToEuro (double arg0)
    throws java.rmi.RemoteException {
    return ConverterPOAInvokeHandler.yenToEuro(_target, arg0);
  }
}
