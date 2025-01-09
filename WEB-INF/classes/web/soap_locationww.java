package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.soap_locationww", "/web.soap_locationww"})
public final  class soap_locationww extends GXWebObjectStub
{
   public soap_locationww( )
   {
   }

   public soap_locationww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( soap_locationww.class ));
   }

   public soap_locationww( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new soap_locationww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new soap_locationww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " soap_location";
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

