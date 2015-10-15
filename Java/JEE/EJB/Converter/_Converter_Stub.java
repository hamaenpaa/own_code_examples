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
public class _Converter_Stub extends javax.ejb._EJBObject_Stub implements Converter, ConverterOperations {
  final public static java.lang.Class _opsClass = ConverterOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "RMI:Converter:0000000000000000",
    "RMI:javax.ejb.EJBObject:0000000000000000"
  };

  /**
   * <pre>
   *   double dollarToYen (in double arg0);
   * </pre>
   */
  public double dollarToYen (double arg0) throws java.rmi.RemoteException {

    try {
      while (true) {
        if (!_is_local()) {
          org.omg.CORBA.portable.OutputStream _output = null;
          org.omg.CORBA.portable.InputStream  _input  = null;
          double _result;
          try {
            _output = this._request("dollarToYen", true);
            _output.write_double((double)arg0);
            _input = this._invoke(_output);
            _result = _input.read_double();
            return _result;
          }
          catch (org.omg.CORBA.portable.ApplicationException _exception) {
            final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
            java.lang.String _exception_id = _exception.getId();
            //FIX: Wrap original Exception here?
            throw new java.rmi.UnexpectedException("Unexpected User Exception: " + _exception_id);
          }
          catch (org.omg.CORBA.portable.RemarshalException _exception) {
            continue;
          }
          finally {
            this._releaseReply(_input);
          }
        } else {
          final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("dollarToYen", _opsClass);
          if (_so == null) {
            continue;
          }
          final ConverterOperations _self = (ConverterOperations)_so.servant;
          try {
            return _self.dollarToYen(arg0);
          }
          finally {
            _servant_postinvoke(_so);
          }
        }
      }
    }
    catch (org.omg.CORBA.portable.UnknownException ex) {
      if (ex.originalEx instanceof java.lang.RuntimeException) {
        throw (java.lang.RuntimeException) ex.originalEx;
      } else if (ex.originalEx instanceof Exception) {
        throw new java.rmi.ServerException(ex.getMessage(), (java.lang.Exception)ex.originalEx);
      } else {
        throw new java.rmi.ServerError(ex.getMessage(), (java.lang.Error) ex.originalEx);
      } 
    }
    catch (org.omg.CORBA.SystemException ex) {
      throw javax.rmi.CORBA.Util.mapSystemException(ex);
    }
  }

  /**
   * <pre>
   *   double yenToEuro (in double arg0);
   * </pre>
   */
  public double yenToEuro (double arg0) throws java.rmi.RemoteException {

    try {
      while (true) {
        if (!_is_local()) {
          org.omg.CORBA.portable.OutputStream _output = null;
          org.omg.CORBA.portable.InputStream  _input  = null;
          double _result;
          try {
            _output = this._request("yenToEuro", true);
            _output.write_double((double)arg0);
            _input = this._invoke(_output);
            _result = _input.read_double();
            return _result;
          }
          catch (org.omg.CORBA.portable.ApplicationException _exception) {
            final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
            java.lang.String _exception_id = _exception.getId();
            //FIX: Wrap original Exception here?
            throw new java.rmi.UnexpectedException("Unexpected User Exception: " + _exception_id);
          }
          catch (org.omg.CORBA.portable.RemarshalException _exception) {
            continue;
          }
          finally {
            this._releaseReply(_input);
          }
        } else {
          final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("yenToEuro", _opsClass);
          if (_so == null) {
            continue;
          }
          final ConverterOperations _self = (ConverterOperations)_so.servant;
          try {
            return _self.yenToEuro(arg0);
          }
          finally {
            _servant_postinvoke(_so);
          }
        }
      }
    }
    catch (org.omg.CORBA.portable.UnknownException ex) {
      if (ex.originalEx instanceof java.lang.RuntimeException) {
        throw (java.lang.RuntimeException) ex.originalEx;
      } else if (ex.originalEx instanceof Exception) {
        throw new java.rmi.ServerException(ex.getMessage(), (java.lang.Exception)ex.originalEx);
      } else {
        throw new java.rmi.ServerError(ex.getMessage(), (java.lang.Error) ex.originalEx);
      } 
    }
    catch (org.omg.CORBA.SystemException ex) {
      throw javax.rmi.CORBA.Util.mapSystemException(ex);
    }
  }

}
