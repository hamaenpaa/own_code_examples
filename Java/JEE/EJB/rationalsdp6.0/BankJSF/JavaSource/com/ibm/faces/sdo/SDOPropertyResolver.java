package com.ibm.faces.sdo;

import java.util.List;

import javax.faces.el.PropertyNotFoundException;
import javax.faces.el.PropertyResolver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import com.ibm.websphere.sdo.DataObjectAccessBean;
import com.ibm.websphere.sdo.access.util.TypeCoercionUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Property;


public class SDOPropertyResolver extends PropertyResolver {

	PropertyResolver oldPropResolver;

	public SDOPropertyResolver(PropertyResolver propResolver) {
		oldPropResolver = propResolver;
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#getValue(java.lang.Object, java.lang.Object)
	 */
	public Object getValue(Object base, Object property)
		throws PropertyNotFoundException {

		try {
			if(base instanceof DataObject){
				if(property != null){
					return (((DataObject) base).get(property.toString()));
				}
			} 
			else if (base instanceof DataObjectAccessBean) {
				return (((DataObjectAccessBean) base).get(property));
			}
			
		} catch (NoClassDefFoundError ncdfe) {
			// wdo jars are not available
		}

		if (oldPropResolver != null) {
			return oldPropResolver.getValue(base, property);
		}
		throw new PropertyNotFoundException();
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#getValue(java.lang.Object, int)
	 */
	public Object getValue(Object base, int index)
		throws PropertyNotFoundException {

		if (oldPropResolver != null) {
			return oldPropResolver.getValue(base, index);
		}
		throw new PropertyNotFoundException();
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#setValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	public void setValue(Object base, Object property, Object value)
		throws PropertyNotFoundException {

		if ((base == null) || (property == null)) {
			String className =
				base == null ? "null" : base.getClass().getName();
			throw new PropertyNotFoundException(
				"Error setting property '"
					+ property
					+ "' in bean of type "
					+ className);
		}

		try {
			if(base instanceof DataObject){
				if(property != null){
					((DataObject) base).set(property.toString(),
							TypeCoercionUtil.coerceType(getType(base, property)
									.getName(), value));
					return;
				}
			} 
			else if (base instanceof DataObjectAccessBean) {
				((DataObjectAccessBean) base).put(property, value);
				return;
			}
		} catch (NoClassDefFoundError ncdfe) {
			// wdo jars are not available
		}

		if (oldPropResolver != null) {
			oldPropResolver.setValue(base, property, value);
			return;
		}
		throw new PropertyNotFoundException();
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#setValue(java.lang.Object, int, java.lang.Object)
	 */
	public void setValue(Object base, int index, Object value)
		throws PropertyNotFoundException {

		try {
			if(base instanceof DataObject){
				((DataObject) base).set(index,
						TypeCoercionUtil.coerceType(getType(base, index)
								.getName(), value));
				return;
			} 
		} catch (NoClassDefFoundError ncdfe) {
			// wdo jars are not available
		}
		
		if (oldPropResolver != null) {
			oldPropResolver.setValue(base, index, value);
			return;
		}
		throw new PropertyNotFoundException();
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#isReadOnly(java.lang.Object, java.lang.Object)
	 */
	public boolean isReadOnly(Object base, Object property)
		throws PropertyNotFoundException {

		if ((base == null) || (property == null)) {
			String className =
				base == null ? "null" : base.getClass().getName();
			throw new PropertyNotFoundException(
				"Error testing property '"
					+ property
					+ "' in bean of type "
					+ className);
		}

		try {
			if (base instanceof DataObjectAccessBean) {
				if (property instanceof String) {
					return ((DataObjectAccessBean) base).isReadOnly(
						(String) property);
				} else {
					String className =
						base == null ? "null" : base.getClass().getName();
					throw new PropertyNotFoundException(
						"Property '"
							+ property
							+ "' is not a String in bean of type "
							+ className);
				}
			}
		} catch (NoClassDefFoundError ncdfe) {
			// wdo jars are not available
		} catch (Exception e) {
			throw new PropertyNotFoundException(e);
		}

		if (oldPropResolver != null) {
			return oldPropResolver.isReadOnly(base, property);
		}
		throw new PropertyNotFoundException();
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#isReadOnly(java.lang.Object, int)
	 */
	public boolean isReadOnly(Object base, int index)
		throws PropertyNotFoundException {

		if (base == null) {
			throw new NullPointerException();
		}
		try {
			if (!(base instanceof DataObjectAccessBean)) {
				return oldPropResolver.isReadOnly(base, index);
			}
		} catch (NoClassDefFoundError ncdfe) {
			// wdo jars are not available
			return oldPropResolver.isReadOnly(base, index);
		}
		throw new PropertyNotFoundException();
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#getType(java.lang.Object, java.lang.Object)
	 */
	public Class getType(Object base, Object property)
		throws PropertyNotFoundException {

		if ((base == null) || (property == null)) {
			String className =
				base == null ? "null" : base.getClass().getName();
			throw new PropertyNotFoundException(
				"Error testing property '"
					+ property
					+ "' in bean of type "
					+ className);
		}

		try {
			if(base instanceof DataObject){
				if(property != null){
					Property prop = 
						((DataObject) base).getType().getProperty(property.toString());
					
					Class retClass = null;
					
					if(prop != null){
						if(prop.isMany()){
							if(base instanceof EObject){
								retClass= EcoreEList.class;
							}else{
								retClass = List.class;
							}
						} else if(prop.getType().getInstanceClass() == null){
							retClass = DataObject.class;
						} else{
							retClass = prop.getType().getInstanceClass();
						}
					}
					return retClass;
				}
			}
			else if (base instanceof DataObjectAccessBean) {
				if (property instanceof String) {
					return ((DataObjectAccessBean) base).getType(
						(String) property);
				} else {

					String className =
						base == null ? "null" : base.getClass().getName();
					throw new PropertyNotFoundException(
						"Error testing property '"
							+ property
							+ "' in bean of type "
							+ className);
				}
			}
		} catch (NoClassDefFoundError ncdfe) {
			// wdo jars are not available
		} catch (Exception e) {
			throw new PropertyNotFoundException(e);
		}

		if (oldPropResolver != null) {
			return oldPropResolver.getType(base, property);
		}
		throw new PropertyNotFoundException();
	}

	/* (non-Javadoc)
	 * @see javax.faces.el.PropertyResolver#getType(java.lang.Object, int)
	 */
	public Class getType(Object base, int index)
		throws PropertyNotFoundException {

		if (base == null) {
			throw new NullPointerException();
		}
		try {
			if(base instanceof EcoreEList){
				if(((EcoreEList)base).getEStructuralFeature().getEType().getInstanceClass() == null){
					return DataObject.class;
				}
				else{
					return ((EcoreEList)base).getEStructuralFeature().getEType().getInstanceClass();
				}
			}
			if (!(base instanceof DataObjectAccessBean)) {
				return oldPropResolver.getType(base, index);
			}
		} catch (NoClassDefFoundError ncdfe) {
			// wdo jars are not available
			return oldPropResolver.getType(base, index);
		}
		throw new PropertyNotFoundException();
	}

}
