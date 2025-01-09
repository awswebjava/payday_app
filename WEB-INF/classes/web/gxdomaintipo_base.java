package web ;
import web.*;
import com.genexus.*;

public final  class gxdomaintipo_base
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"licencia"), "Licencia");
      domain.put(new String((String)"feriado"), "Feriado/No laborable");
      domain.put(new String((String)"horaNormal"), "Hora Normal");
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

