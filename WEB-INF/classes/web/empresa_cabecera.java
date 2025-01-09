package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_cabecera", "/web.empresa_cabecera"})
public final  class empresa_cabecera extends GXWebObjectStub
{
   public empresa_cabecera( )
   {
   }

   public empresa_cabecera( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_cabecera.class ));
   }

   public empresa_cabecera( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_cabecera_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_cabecera_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa";
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

