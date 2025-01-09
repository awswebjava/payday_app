package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importarliquidacioneswizard2", "/web.importarliquidacioneswizard2"})
public final  class importarliquidacioneswizard2 extends GXWebObjectStub
{
   public importarliquidacioneswizard2( )
   {
   }

   public importarliquidacioneswizard2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importarliquidacioneswizard2.class ));
   }

   public importarliquidacioneswizard2( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importarliquidacioneswizard2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importarliquidacioneswizard2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Importar liquidaciones históricas";
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

