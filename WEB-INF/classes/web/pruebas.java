package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.pruebas", "/web.pruebas"})
public final  class pruebas extends GXWebObjectStub
{
   public pruebas( )
   {
   }

   public pruebas( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( pruebas.class ));
   }

   public pruebas( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new pruebas_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new pruebas_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pruebas";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

