package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisextraordinariasview", "/web.paisextraordinariasview"})
public final  class paisextraordinariasview extends GXWebObjectStub
{
   public paisextraordinariasview( )
   {
   }

   public paisextraordinariasview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisextraordinariasview.class ));
   }

   public paisextraordinariasview( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisextraordinariasview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisextraordinariasview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Extraordinarias View";
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

