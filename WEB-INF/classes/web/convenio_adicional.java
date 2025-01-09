package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicional", "/web.convenio_adicional"})
public final  class convenio_adicional extends GXWebObjectStub
{
   public convenio_adicional( )
   {
   }

   public convenio_adicional( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicional.class ));
   }

   public convenio_adicional( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicional_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicional_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional";
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

