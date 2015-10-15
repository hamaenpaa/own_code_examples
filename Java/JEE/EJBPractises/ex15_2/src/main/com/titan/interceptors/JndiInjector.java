package com.titan.interceptors;

import java.lang.reflect.*;
import com.titan.annotations.JndiInjected;
import javax.ejb.*;
import javax.interceptor.*;
import javax.naming.*;
import javax.annotation.PostConstruct;

public class JndiInjector {

   @PostConstruct
   public void jndiInject(InvocationContext invocation) {
      Object target = invocation.getTarget(); //  .getBean();
      Field[] fields = target.getClass().getDeclaredFields();
      Method[] methods = target.getClass().getDeclaredMethods();

      // find all @JndiInjected fields methods and set them
      try {
         InitialContext ctx = new InitialContext();
         for (Method method : methods) {
            JndiInjected inject = method.getAnnotation(JndiInjected.class);
            if (inject != null) {
               Object obj = ctx.lookup(inject.value());
               method.setAccessible(true);
               method.invoke(target, obj);
            }
         }
         for (Field field : fields) {
            JndiInjected inject = field.getAnnotation(JndiInjected.class);
            if (inject != null) {
               Object obj = ctx.lookup(inject.value());
               field.setAccessible(true);
               field.set(target, obj);
            }
         }
         invocation.proceed();
      } catch (Exception ex) {
         throw new EJBException("Failed to execute @JndiInjected", ex);
      }
   }
}
