package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipotrabajoview", "/web.tipotrabajoview"})
public final  class tipotrabajoview extends GXWebObjectStub
{
   public tipotrabajoview( )
   {
   }

   public tipotrabajoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipotrabajoview.class ));
   }

   public tipotrabajoview( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipotrabajoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipotrabajoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Trabajo View";
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

