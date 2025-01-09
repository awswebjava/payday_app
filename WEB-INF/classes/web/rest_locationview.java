package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.rest_locationview", "/web.rest_locationview"})
public final  class rest_locationview extends GXWebObjectStub
{
   public rest_locationview( )
   {
   }

   public rest_locationview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rest_locationview.class ));
   }

   public rest_locationview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rest_locationview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rest_locationview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "rest_location View";
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
