package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_particularidadesgeneral", "/web.clienteconvenio_particularidadesgeneral"})
public final  class clienteconvenio_particularidadesgeneral extends GXWebObjectStub
{
   public clienteconvenio_particularidadesgeneral( )
   {
   }

   public clienteconvenio_particularidadesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_particularidadesgeneral.class ));
   }

   public clienteconvenio_particularidadesgeneral( int remoteHandle ,
                                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_particularidadesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_particularidadesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente Convenio_Particularidades General";
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

