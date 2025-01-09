package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_particularidadesww", "/web.clienteconvenio_particularidadesww"})
public final  class clienteconvenio_particularidadesww extends GXWebObjectStub
{
   public clienteconvenio_particularidadesww( )
   {
   }

   public clienteconvenio_particularidadesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_particularidadesww.class ));
   }

   public clienteconvenio_particularidadesww( int remoteHandle ,
                                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_particularidadesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_particularidadesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Cliente Convenio_Particularidades";
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

