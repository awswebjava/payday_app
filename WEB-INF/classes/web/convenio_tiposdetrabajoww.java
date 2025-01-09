package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_tiposdetrabajoww", "/web.convenio_tiposdetrabajoww"})
public final  class convenio_tiposdetrabajoww extends GXWebObjectStub
{
   public convenio_tiposdetrabajoww( )
   {
   }

   public convenio_tiposdetrabajoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_tiposdetrabajoww.class ));
   }

   public convenio_tiposdetrabajoww( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_tiposdetrabajoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_tiposdetrabajoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " convenio_tiposdetrabajo";
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

