package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.provinciaview", "/web.provinciaview"})
public final  class provinciaview extends GXWebObjectStub
{
   public provinciaview( )
   {
   }

   public provinciaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( provinciaview.class ));
   }

   public provinciaview( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new provinciaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new provinciaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Provincia View";
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

