package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_tiposdetrabajoview", "/web.convenio_tiposdetrabajoview"})
public final  class convenio_tiposdetrabajoview extends GXWebObjectStub
{
   public convenio_tiposdetrabajoview( )
   {
   }

   public convenio_tiposdetrabajoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_tiposdetrabajoview.class ));
   }

   public convenio_tiposdetrabajoview( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_tiposdetrabajoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_tiposdetrabajoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_tiposdetrabajo View";
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

