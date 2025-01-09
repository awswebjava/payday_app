package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.agendanovedades", "/web.agendanovedades"})
public final  class agendanovedades extends GXWebObjectStub
{
   public agendanovedades( )
   {
   }

   public agendanovedades( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( agendanovedades.class ));
   }

   public agendanovedades( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new agendanovedades_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new agendanovedades_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Agenda de Novedades";
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
      return "agendanovedades_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

