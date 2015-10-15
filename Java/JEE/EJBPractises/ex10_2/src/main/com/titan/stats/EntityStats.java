package com.titan.stats;

public class EntityStats implements EntityStatsMBean
{
   public String output()
   {
      StringBuffer buf = new StringBuffer("<table><tr><td>Entity Name</td><td>Loads</td><td>Inserts</td><td>Updates</td><td>Deletes</td></tr>");
      for (EntityListener.Stats stats : EntityListener.map.values())
      {
         buf.append("<tr><td>" + stats.entity).append("</td>");
         buf.append("<td>" + stats.loads).append("</td>");
         buf.append("<td>" + stats.inserts).append("</td>");
         buf.append("<td>" + stats.updates).append("</td>");
         buf.append("<td>" + stats.removes).append("</td></tr>");
      }
      buf.append("</table>");
      return buf.toString();
   }
      
      
}
