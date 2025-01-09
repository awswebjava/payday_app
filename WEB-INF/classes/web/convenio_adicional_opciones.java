package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicional_opciones", "/web.convenio_adicional_opciones"})
public final  class convenio_adicional_opciones extends GXWebObjectStub
{
   public convenio_adicional_opciones( )
   {
   }

   public convenio_adicional_opciones( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicional_opciones.class ));
   }

   public convenio_adicional_opciones( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicional_opciones_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicional_opciones_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional_opciones";
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

