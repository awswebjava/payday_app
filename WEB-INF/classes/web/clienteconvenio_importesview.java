package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_importesview", "/web.clienteconvenio_importesview"})
public final  class clienteconvenio_importesview extends GXWebObjectStub
{
   public clienteconvenio_importesview( )
   {
   }

   public clienteconvenio_importesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_importesview.class ));
   }

   public clienteconvenio_importesview( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_importesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_importesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "cliente Convenio_importes View";
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

