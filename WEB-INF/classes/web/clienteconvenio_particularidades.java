package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_particularidades", "/web.clienteconvenio_particularidades"})
public final  class clienteconvenio_particularidades extends GXWebObjectStub
{
   public clienteconvenio_particularidades( )
   {
   }

   public clienteconvenio_particularidades( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_particularidades.class ));
   }

   public clienteconvenio_particularidades( int remoteHandle ,
                                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_particularidades_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_particularidades_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente Convenio_Particularidades";
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

