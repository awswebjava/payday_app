package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_update", "/web.cliente_update"})
public final  class cliente_update extends GXWebObjectStub
{
   public cliente_update( )
   {
   }

   public cliente_update( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_update.class ));
   }

   public cliente_update( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_update_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_update_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Actualizaciones";
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

