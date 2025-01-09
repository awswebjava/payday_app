package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainlic_orig_consumos
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"licencias"), "Licencias aprobadas");
      domain.put(new String((String)"importacion"), "Importación de LSD");
      domain.put(new String((String)"manual"), "Manual");
      domain.put(new String((String)"inicializacion"), "Inicialización automática");
      domain.put(new String((String)"final"), "Liquidación final");
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

