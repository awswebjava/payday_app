package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clientegeneral", "/web.clientegeneral"})
public final  class clientegeneral extends GXWebObjectStub
{
   public clientegeneral( )
   {
   }

   public clientegeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientegeneral.class ));
   }

   public clientegeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientegeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientegeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente General";
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

