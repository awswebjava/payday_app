package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.actividadafipview", "/web.actividadafipview"})
public final  class actividadafipview extends GXWebObjectStub
{
   public actividadafipview( )
   {
   }

   public actividadafipview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( actividadafipview.class ));
   }

   public actividadafipview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new actividadafipview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new actividadafipview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Actividad AFIPView";
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

