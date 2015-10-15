package sample;
/**
 * Bean implementation class for Enterprise Bean: Author
 */
public abstract class AuthorBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public java.lang.Integer ejbCreate(java.lang.Integer id)
		throws javax.ejb.CreateException {
		setId(id);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.Integer id)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: id
	 */
	public abstract java.lang.Integer getId();
	/**
	 * Set accessor for persistent attribute: id
	 */
	public abstract void setId(java.lang.Integer newId);
	/**
	 * Get accessor for persistent attribute: name
	 */
	public abstract java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public abstract void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: age
	 */
	public abstract java.lang.Integer getAge();
	/**
	 * Set accessor for persistent attribute: age
	 */
	public abstract void setAge(java.lang.Integer newAge);
}