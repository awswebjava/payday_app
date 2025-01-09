package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainconceptotipo
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"REM_ARG"), "Remunerativo");
      domain.put(new String((String)"NRE_ARG"), "No Remunerativo");
      domain.put(new String((String)"DES_ARG"), "Retención");
      domain.put(new String((String)"CAL_ARG"), "Cálculo");
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

