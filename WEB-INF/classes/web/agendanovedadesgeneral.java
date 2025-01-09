package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.agendanovedadesgeneral", "/web.agendanovedadesgeneral"})
public final  class agendanovedadesgeneral extends GXWebObjectStub
{
   public agendanovedadesgeneral( )
   {
   }

   public agendanovedadesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( agendanovedadesgeneral.class ));
   }

   public agendanovedadesgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new agendanovedadesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new agendanovedadesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Agenda Novedades General";
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

