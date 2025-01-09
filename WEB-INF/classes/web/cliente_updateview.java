package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_updateview", "/web.cliente_updateview"})
public final  class cliente_updateview extends GXWebObjectStub
{
   public cliente_updateview( )
   {
   }

   public cliente_updateview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_updateview.class ));
   }

   public cliente_updateview( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_updateview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_updateview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente_Update View";
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

