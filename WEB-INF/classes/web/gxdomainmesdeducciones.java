package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainmesdeducciones
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "Enero");
      domain.put(new Byte((byte)2), "Febrero");
      domain.put(new Byte((byte)3), "Marzo");
      domain.put(new Byte((byte)4), "Abril");
      domain.put(new Byte((byte)5), "Mayo");
      domain.put(new Byte((byte)6), "Junio");
      domain.put(new Byte((byte)7), "Julio");
      domain.put(new Byte((byte)8), "Agosto");
      domain.put(new Byte((byte)9), "Septiembre");
      domain.put(new Byte((byte)10), "Octubre");
      domain.put(new Byte((byte)11), "Noviembre");
      domain.put(new Byte((byte)12), "Diciembre");
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

