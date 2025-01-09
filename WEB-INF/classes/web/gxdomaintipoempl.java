package web ;
import web.*;
import com.genexus.*;

public final  class gxdomaintipoempl
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"0"), "Administración Pública");
      domain.put(new String((String)"1"), "Decreto N 814/01 art. 2 inciso b)");
      domain.put(new String((String)"2"), "Servicios eventuales. Decto N 814/01 art. 2 inc b)");
      domain.put(new String((String)"3"), "Provincias u otros");
      domain.put(new String((String)"4"), "Decreto N 814/01 art. 2 inciso a)");
      domain.put(new String((String)"5"), "Servicios eventuales. Decto N 814/01 art. 2 inc a)");
      domain.put(new String((String)"6"), "Decreto N 814/01 art. 2 inciso b) Prov.Ley N 22016");
      domain.put(new String((String)"7"), "Colegios privados");
      domain.put(new String((String)"8"), "Decreto 1212/03 - AFA Clubes");
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

