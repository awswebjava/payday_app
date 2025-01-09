package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_importesww", "/web.clienteconvenio_importesww"})
public final  class clienteconvenio_importesww extends GXWebObjectStub
{
   public clienteconvenio_importesww( )
   {
   }

   public clienteconvenio_importesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_importesww.class ));
   }

   public clienteconvenio_importesww( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_importesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_importesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " cliente Convenio_importes";
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

