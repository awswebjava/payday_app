package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_importesgeneral", "/web.clienteconvenio_importesgeneral"})
public final  class clienteconvenio_importesgeneral extends GXWebObjectStub
{
   public clienteconvenio_importesgeneral( )
   {
   }

   public clienteconvenio_importesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_importesgeneral.class ));
   }

   public clienteconvenio_importesgeneral( int remoteHandle ,
                                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_importesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_importesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "cliente Convenio_importes General";
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

