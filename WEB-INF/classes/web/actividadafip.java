package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.actividadafip", "/web.actividadafip"})
public final  class actividadafip extends GXWebObjectStub
{
   public actividadafip( )
   {
   }

   public actividadafip( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( actividadafip.class ));
   }

   public actividadafip( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new actividadafip_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new actividadafip_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Actividad AFIP";
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

