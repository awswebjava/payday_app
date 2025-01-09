package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_abm_1", "/web.empresa_abm_1"})
public final  class empresa_abm_1 extends GXWebObjectStub
{
   public empresa_abm_1( )
   {
   }

   public empresa_abm_1( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_abm_1.class ));
   }

   public empresa_abm_1( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_abm_1_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_abm_1_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa_abm_1";
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
      return "empresa_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

