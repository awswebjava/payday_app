package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_tiposdetrabajogeneral", "/web.empresa_tiposdetrabajogeneral"})
public final  class empresa_tiposdetrabajogeneral extends GXWebObjectStub
{
   public empresa_tiposdetrabajogeneral( )
   {
   }

   public empresa_tiposdetrabajogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_tiposdetrabajogeneral.class ));
   }

   public empresa_tiposdetrabajogeneral( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_tiposdetrabajogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_tiposdetrabajogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "empresa_tiposdetrabajo General";
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

