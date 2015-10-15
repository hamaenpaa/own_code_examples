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
public final class ConverterHomeHolder implements org.omg.CORBA.portable.Streamable {
  public ConverterHome value;

  public ConverterHomeHolder () {
  }

  public ConverterHomeHolder (final ConverterHome _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = ConverterHomeHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    ConverterHomeHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return ConverterHomeHelper.type();
  }
}
