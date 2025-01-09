package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_tiposdetrabajogeneral", "/web.convenio_tiposdetrabajogeneral"})
public final  class convenio_tiposdetrabajogeneral extends GXWebObjectStub
{
   public convenio_tiposdetrabajogeneral( )
   {
   }

   public convenio_tiposdetrabajogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_tiposdetrabajogeneral.class ));
   }

   public convenio_tiposdetrabajogeneral( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_tiposdetrabajogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_tiposdetrabajogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_tiposdetrabajo General";
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

