package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_aplicacion_gananciasview", "/web.tipo_aplicacion_gananciasview"})
public final  class tipo_aplicacion_gananciasview extends GXWebObjectStub
{
   public tipo_aplicacion_gananciasview( )
   {
   }

   public tipo_aplicacion_gananciasview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_aplicacion_gananciasview.class ));
   }

   public tipo_aplicacion_gananciasview( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_aplicacion_gananciasview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_aplicacion_gananciasview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "tipo_aplicacion_ganancias View";
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
