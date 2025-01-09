package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_importes", "/web.clienteconvenio_importes"})
public final  class clienteconvenio_importes extends GXWebObjectStub
{
   public clienteconvenio_importes( )
   {
   }

   public clienteconvenio_importes( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_importes.class ));
   }

   public clienteconvenio_importes( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_importes_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_importes_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "cliente Convenio_importes";
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

