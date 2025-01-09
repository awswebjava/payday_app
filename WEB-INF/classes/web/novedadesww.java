package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.novedadesww", "/web.novedadesww"})
public final  class novedadesww extends GXWebObjectStub
{
   public novedadesww( )
   {
   }

   public novedadesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( novedadesww.class ));
   }

   public novedadesww( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new novedadesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new novedadesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Agenda de Novedades";
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

