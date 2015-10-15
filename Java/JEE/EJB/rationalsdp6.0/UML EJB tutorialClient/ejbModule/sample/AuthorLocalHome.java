package sample;
/**
 * Local Home interface for Enterprise Bean: Author
 */
public interface AuthorLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: Author
	 */
	public sample.AuthorLocal create(java.lang.Integer id)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: Author
	 */
	public sample.AuthorLocal findByPrimaryKey(java.lang.Integer primaryKey)
		throws javax.ejb.FinderException;
}