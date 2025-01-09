package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_cuenta_licenciasview", "/web.legajo_cuenta_licenciasview"})
public final  class legajo_cuenta_licenciasview extends GXWebObjectStub
{
   public legajo_cuenta_licenciasview( )
   {
   }

   public legajo_cuenta_licenciasview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_cuenta_licenciasview.class ));
   }

   public legajo_cuenta_licenciasview( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_cuenta_licenciasview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_cuenta_licenciasview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "legajo_cuenta_licencias View";
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

