package web ;
import web.*;
import com.genexus.*;

public final  class gxdomaines_base_osdif
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)0), "No");
      domain.put(new Byte((byte)1), "Sí. Recalcular proporcional a jornada completa");
      domain.put(new Byte((byte)2), "Sí, el valor liquidado");
      domain.put(new Byte((byte)3), "Sí, el valor liquidado proporcional a jornada completa");
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

