package sample;
/**
 * Local interface for Enterprise Bean: Book
 */
public interface BookLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: title
	 */
	public java.lang.String getTitle();
	/**
	 * Set accessor for persistent attribute: title
	 */
	public void setTitle(java.lang.String newTitle);
}