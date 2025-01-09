package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajoagendanovedadeswc", "/web.legajoagendanovedadeswc"})
public final  class legajoagendanovedadeswc extends GXWebObjectStub
{
   public legajoagendanovedadeswc( )
   {
   }

   public legajoagendanovedadeswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajoagendanovedadeswc.class ));
   }

   public legajoagendanovedadeswc( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajoagendanovedadeswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajoagendanovedadeswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo Agenda Novedades WC";
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

