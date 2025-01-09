package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.novedadesview", "/web.novedadesview"})
public final  class novedadesview extends GXWebObjectStub
{
   public novedadesview( )
   {
   }

   public novedadesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( novedadesview.class ));
   }

   public novedadesview( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new novedadesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new novedadesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Novedades View";
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

