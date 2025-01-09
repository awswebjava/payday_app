package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_tiposdetrabajo", "/web.convenio_tiposdetrabajo"})
public final  class convenio_tiposdetrabajo extends GXWebObjectStub
{
   public convenio_tiposdetrabajo( )
   {
   }

   public convenio_tiposdetrabajo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_tiposdetrabajo.class ));
   }

   public convenio_tiposdetrabajo( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_tiposdetrabajo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_tiposdetrabajo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_tiposdetrabajo";
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

