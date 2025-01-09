package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.agendanovedadesnovedades", "/web.agendanovedadesnovedades"})
public final  class agendanovedadesnovedades extends GXWebObjectStub
{
   public agendanovedadesnovedades( )
   {
   }

   public agendanovedadesnovedades( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( agendanovedadesnovedades.class ));
   }

   public agendanovedadesnovedades( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new agendanovedadesnovedades_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new agendanovedadesnovedades_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Agenda Novedades Novedades";
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

