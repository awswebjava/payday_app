package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_deduccionesgeneral", "/web.legajo_deduccionesgeneral"})
public final  class legajo_deduccionesgeneral extends GXWebObjectStub
{
   public legajo_deduccionesgeneral( )
   {
   }

   public legajo_deduccionesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_deduccionesgeneral.class ));
   }

   public legajo_deduccionesgeneral( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_deduccionesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_deduccionesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "legajo_deducciones General";
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

