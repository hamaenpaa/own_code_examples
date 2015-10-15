package sample;
/**
 * Local interface for Enterprise Bean: Author
 */
public interface AuthorLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: age
	 */
	public java.lang.Integer getAge();
	/**
	 * Set accessor for persistent attribute: age
	 */
	public void setAge(java.lang.Integer newAge);
}