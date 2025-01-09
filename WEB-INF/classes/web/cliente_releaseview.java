package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_releaseview", "/web.cliente_releaseview"})
public final  class cliente_releaseview extends GXWebObjectStub
{
   public cliente_releaseview( )
   {
   }

   public cliente_releaseview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_releaseview.class ));
   }

   public cliente_releaseview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_releaseview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_releaseview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente_Release View";
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

