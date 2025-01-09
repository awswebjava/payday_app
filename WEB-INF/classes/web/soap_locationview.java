package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.soap_locationview", "/web.soap_locationview"})
public final  class soap_locationview extends GXWebObjectStub
{
   public soap_locationview( )
   {
   }

   public soap_locationview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( soap_locationview.class ));
   }

   public soap_locationview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new soap_locationview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new soap_locationview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "soap_location View";
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

