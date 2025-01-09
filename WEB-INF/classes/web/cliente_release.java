package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_release", "/web.cliente_release"})
public final  class cliente_release extends GXWebObjectStub
{
   public cliente_release( )
   {
   }

   public cliente_release( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_release.class ));
   }

   public cliente_release( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_release_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_release_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liberación de actualizaciones";
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

