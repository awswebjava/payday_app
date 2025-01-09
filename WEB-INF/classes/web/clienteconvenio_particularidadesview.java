package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_particularidadesview", "/web.clienteconvenio_particularidadesview"})
public final  class clienteconvenio_particularidadesview extends GXWebObjectStub
{
   public clienteconvenio_particularidadesview( )
   {
   }

   public clienteconvenio_particularidadesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_particularidadesview.class ));
   }

   public clienteconvenio_particularidadesview( int remoteHandle ,
                                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_particularidadesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_particularidadesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente Convenio_Particularidades View";
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

