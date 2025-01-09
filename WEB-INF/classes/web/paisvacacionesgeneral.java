package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisvacacionesgeneral", "/web.paisvacacionesgeneral"})
public final  class paisvacacionesgeneral extends GXWebObjectStub
{
   public paisvacacionesgeneral( )
   {
   }

   public paisvacacionesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisvacacionesgeneral.class ));
   }

   public paisvacacionesgeneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisvacacionesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisvacacionesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Vacaciones General";
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

