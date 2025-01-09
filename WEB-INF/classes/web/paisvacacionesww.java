package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisvacacionesww", "/web.paisvacacionesww"})
public final  class paisvacacionesww extends GXWebObjectStub
{
   public paisvacacionesww( )
   {
   }

   public paisvacacionesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisvacacionesww.class ));
   }

   public paisvacacionesww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisvacacionesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisvacacionesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Pais Vacaciones";
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

