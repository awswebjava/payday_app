package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainoperador_comparacion
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"menor"), "<");
      domain.put(new String((String)"mayor"), ">");
      domain.put(new String((String)"igual"), "=");
      domain.put(new String((String)"menorOIgual"), "<=");
      domain.put(new String((String)"mayorOIgual"), ">=");
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

