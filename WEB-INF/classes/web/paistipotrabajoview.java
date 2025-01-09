package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paistipotrabajoview", "/web.paistipotrabajoview"})
public final  class paistipotrabajoview extends GXWebObjectStub
{
   public paistipotrabajoview( )
   {
   }

   public paistipotrabajoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paistipotrabajoview.class ));
   }

   public paistipotrabajoview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paistipotrabajoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paistipotrabajoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Tipo Trabajo View";
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

