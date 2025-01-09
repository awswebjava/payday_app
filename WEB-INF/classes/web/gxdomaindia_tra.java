package web ;
import web.*;
import com.genexus.*;

public final  class gxdomaindia_tra
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "Domingo");
      domain.put(new Byte((byte)2), "Lunes");
      domain.put(new Byte((byte)3), "Martes");
      domain.put(new Byte((byte)4), "Miércoles");
      domain.put(new Byte((byte)5), "Jueves");
      domain.put(new Byte((byte)6), "Viernes");
      domain.put(new Byte((byte)7), "Sábado");
      domain.put(new Byte((byte)8), "Feriado");
      domain.put(new Byte((byte)9), "Día hábil no especificado");
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

