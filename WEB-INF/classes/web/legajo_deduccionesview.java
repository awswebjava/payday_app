package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_deduccionesview", "/web.legajo_deduccionesview"})
public final  class legajo_deduccionesview extends GXWebObjectStub
{
   public legajo_deduccionesview( )
   {
   }

   public legajo_deduccionesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_deduccionesview.class ));
   }

   public legajo_deduccionesview( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_deduccionesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_deduccionesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "legajo_deducciones View";
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

