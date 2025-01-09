package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_tiposdetrabajoview", "/web.empresa_tiposdetrabajoview"})
public final  class empresa_tiposdetrabajoview extends GXWebObjectStub
{
   public empresa_tiposdetrabajoview( )
   {
   }

   public empresa_tiposdetrabajoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_tiposdetrabajoview.class ));
   }

   public empresa_tiposdetrabajoview( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_tiposdetrabajoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_tiposdetrabajoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "empresa_tiposdetrabajo View";
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

