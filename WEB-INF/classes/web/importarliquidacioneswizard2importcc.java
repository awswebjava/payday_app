package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importarliquidacioneswizard2importcc", "/web.importarliquidacioneswizard2importcc"})
public final  class importarliquidacioneswizard2importcc extends GXWebObjectStub
{
   public importarliquidacioneswizard2importcc( )
   {
   }

   public importarliquidacioneswizard2importcc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importarliquidacioneswizard2importcc.class ));
   }

   public importarliquidacioneswizard2importcc( int remoteHandle ,
                                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importarliquidacioneswizard2importcc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importarliquidacioneswizard2importcc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Importar Liquidaciones Wizard2 Import CC";
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

