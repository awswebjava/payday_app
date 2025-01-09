package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.rolusuario", "/web.rolusuario"})
public final  class rolusuario extends GXWebObjectStub
{
   public rolusuario( )
   {
   }

   public rolusuario( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rolusuario.class ));
   }

   public rolusuario( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rolusuario_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rolusuario_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Rol Usuario";
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

