package web ;
import web.*;
import com.genexus.*;

public final  class gxdomaines_base
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)0), "No");
      domain.put(new Byte((byte)1), "Sí");
      domain.put(new Byte((byte)2), "Sí, para trabajadores con tarifa \"Por hora\"");
      domain.put(new Byte((byte)3), "Sí, para trabajadores con tarifa \"Por periodo\"");
      domain.put(new Byte((byte)4), "Sí, mientras sea habitual");
      domain.put(new Byte((byte)5), "Sí, para trabajadores con tarifa \"Por hora\", mientras sea habitual");
      domain.put(new Byte((byte)6), "Sí, para trabajadores con tarifa \"Por periodo\", mientras sea habitual");
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

