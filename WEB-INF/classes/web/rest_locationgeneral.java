package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.rest_locationgeneral", "/web.rest_locationgeneral"})
public final  class rest_locationgeneral extends GXWebObjectStub
{
   public rest_locationgeneral( )
   {
   }

   public rest_locationgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rest_locationgeneral.class ));
   }

   public rest_locationgeneral( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rest_locationgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rest_locationgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "rest_location General";
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

