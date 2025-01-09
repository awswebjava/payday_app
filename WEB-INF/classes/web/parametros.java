package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.parametros", "/web.parametros"})
public final  class parametros extends GXWebObjectStub
{
   public parametros( )
   {
   }

   public parametros( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( parametros.class ));
   }

   public parametros( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new parametros_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new parametros_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Parámetros";
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

