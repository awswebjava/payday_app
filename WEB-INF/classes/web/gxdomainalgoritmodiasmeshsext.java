package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainalgoritmodiasmeshsext
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Promedio"), "Promedio anual de días hábiles semanales por mes del empleado");
      domain.put(new String((String)"diasSemanaX4"), "Cantidad de días hábiles semanales del empleado multiplicados por 4");
      domain.put(new String((String)"diasSemanaMes"), "Cantidad de días hábiles del empleado en el mes específico de la liquidación");
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

