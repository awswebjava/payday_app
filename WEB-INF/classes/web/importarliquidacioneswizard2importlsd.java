package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importarliquidacioneswizard2importlsd", "/web.importarliquidacioneswizard2importlsd"})
public final  class importarliquidacioneswizard2importlsd extends GXWebObjectStub
{
   public importarliquidacioneswizard2importlsd( )
   {
   }

   public importarliquidacioneswizard2importlsd( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importarliquidacioneswizard2importlsd.class ));
   }

   public importarliquidacioneswizard2importlsd( int remoteHandle ,
                                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importarliquidacioneswizard2importlsd_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importarliquidacioneswizard2importlsd_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Importar Liquidaciones Wizard2 Import LSD";
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

