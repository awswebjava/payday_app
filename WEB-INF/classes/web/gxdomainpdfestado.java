package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainpdfestado
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Completo"), "Completo");
      domain.put(new String((String)"Enviado"), "Enviado");
      domain.put(new String((String)"Pendiente"), "Procesando...");
      domain.put(new String((String)"Error"), "Error");
      domain.put(new String((String)"Manual"), "Manual");
      domain.put(new String((String)"EnEspera"), "Pendiente");
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

