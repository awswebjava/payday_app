package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importarliquidacioneswizard2confirmarlsdimport", "/web.importarliquidacioneswizard2confirmarlsdimport"})
public final  class importarliquidacioneswizard2confirmarlsdimport extends GXWebObjectStub
{
   public importarliquidacioneswizard2confirmarlsdimport( )
   {
   }

   public importarliquidacioneswizard2confirmarlsdimport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importarliquidacioneswizard2confirmarlsdimport.class ));
   }

   public importarliquidacioneswizard2confirmarlsdimport( int remoteHandle ,
                                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importarliquidacioneswizard2confirmarlsdimport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importarliquidacioneswizard2confirmarlsdimport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Importar Liquidaciones Wizard2 Confirmar LSDImport";
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

