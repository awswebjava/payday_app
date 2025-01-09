package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.novedades", "/web.novedades"})
public final  class novedades extends GXWebObjectStub
{
   public novedades( )
   {
   }

   public novedades( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( novedades.class ));
   }

   public novedades( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new novedades_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new novedades_impl(context).cleanup();
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

