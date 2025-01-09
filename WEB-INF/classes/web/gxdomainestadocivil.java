package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainestadocivil
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"CAS"), "Casado/a");
      domain.put(new String((String)"CON"), "Conviviente");
      domain.put(new String((String)"DIV"), "Divorciado/a");
      domain.put(new String((String)"SEP"), "Separado/a");
      domain.put(new String((String)"SOL"), "Soltero/a");
      domain.put(new String((String)"VIU"), "Viudo/a");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return httpContext != null ? httpContext.getMessage((String)domain.get( key.trim() )) : (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

