package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainsac_devengamiento
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)0), "No aplica");
      domain.put(new Byte((byte)1), "Mensual");
      domain.put(new Byte((byte)3), "Trimestral");
      domain.put(new Byte((byte)4), "Cuatrimestral");
      domain.put(new Byte((byte)6), "Semestral");
      domain.put(new Byte((byte)12), "Anual");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        byte key )
   {
      if (domain.containsKey( key ))
      {
         return httpContext != null ? httpContext.getMessage((String)domain.get( key )) : (String)domain.get( key );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<Byte> getValues( )
   {
      GXSimpleCollection<Byte> value = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Byte) itr.next());
      }
      return value;
   }

}

