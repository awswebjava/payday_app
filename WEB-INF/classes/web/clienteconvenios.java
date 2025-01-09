package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconvenios", "/web.clienteconvenios"})
public final  class clienteconvenios extends GXWebObjectStub
{
   public clienteconvenios( )
   {
   }

   public clienteconvenios( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconvenios.class ));
   }

   public clienteconvenios( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconvenios_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconvenios_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente Convenios";
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

