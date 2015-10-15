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
public final class ConverterHolder implements org.omg.CORBA.portable.Streamable {
  public Converter value;

  public ConverterHolder () {
  }

  public ConverterHolder (final Converter _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = ConverterHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    ConverterHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return ConverterHelper.type();
  }
}
