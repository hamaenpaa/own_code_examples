package sample;
/**
 * Local Home interface for Enterprise Bean: Book
 */
public interface BookLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Book
	 */
	public sample.BookLocal create(java.lang.Integer id)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Book
	 */
	public sample.BookLocal findByPrimaryKey(java.lang.Integer primaryKey)
		throws javax.ejb.FinderException;
}