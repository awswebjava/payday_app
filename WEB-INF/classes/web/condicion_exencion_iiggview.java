package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condicion_exencion_iiggview", "/web.condicion_exencion_iiggview"})
public final  class condicion_exencion_iiggview extends GXWebObjectStub
{
   public condicion_exencion_iiggview( )
   {
   }

   public condicion_exencion_iiggview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condicion_exencion_iiggview.class ));
   }

   public condicion_exencion_iiggview( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condicion_exencion_iiggview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condicion_exencion_iiggview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "condicion_exencion_iigg View";
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

