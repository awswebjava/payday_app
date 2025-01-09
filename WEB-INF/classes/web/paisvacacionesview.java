package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisvacacionesview", "/web.paisvacacionesview"})
public final  class paisvacacionesview extends GXWebObjectStub
{
   public paisvacacionesview( )
   {
   }

   public paisvacacionesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisvacacionesview.class ));
   }

   public paisvacacionesview( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisvacacionesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisvacacionesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Vacaciones View";
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

