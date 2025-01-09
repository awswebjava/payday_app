package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.rest_location", "/web.rest_location"})
public final  class rest_location extends GXWebObjectStub
{
   public rest_location( )
   {
   }

   public rest_location( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rest_location.class ));
   }

   public rest_location( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rest_location_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rest_location_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "rest_location";
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

