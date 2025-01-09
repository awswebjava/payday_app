package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.actualizartarifas", "/web.actualizartarifas"})
public final  class actualizartarifas extends GXWebObjectStub
{
   public actualizartarifas( )
   {
   }

   public actualizartarifas( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( actualizartarifas.class ));
   }

   public actualizartarifas( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new actualizartarifas_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new actualizartarifas_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Actualizar tarifas por porcentaje";
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

