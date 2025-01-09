package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.rolusuariogeneral", "/web.rolusuariogeneral"})
public final  class rolusuariogeneral extends GXWebObjectStub
{
   public rolusuariogeneral( )
   {
   }

   public rolusuariogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rolusuariogeneral.class ));
   }

   public rolusuariogeneral( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rolusuariogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rolusuariogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Rol Usuario General";
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

