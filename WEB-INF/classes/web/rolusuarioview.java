package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.rolusuarioview", "/web.rolusuarioview"})
public final  class rolusuarioview extends GXWebObjectStub
{
   public rolusuarioview( )
   {
   }

   public rolusuarioview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rolusuarioview.class ));
   }

   public rolusuarioview( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rolusuarioview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rolusuarioview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Rol Usuario View";
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

