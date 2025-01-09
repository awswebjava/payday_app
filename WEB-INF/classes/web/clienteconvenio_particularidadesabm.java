package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenio_particularidadesabm", "/web.clienteconvenio_particularidadesabm"})
public final  class clienteconvenio_particularidadesabm extends GXWebObjectStub
{
   public clienteconvenio_particularidadesabm( )
   {
   }

   public clienteconvenio_particularidadesabm( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenio_particularidadesabm.class ));
   }

   public clienteconvenio_particularidadesabm( int remoteHandle ,
                                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenio_particularidadesabm_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenio_particularidadesabm_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente Convenio_Particularidades ABM";
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

