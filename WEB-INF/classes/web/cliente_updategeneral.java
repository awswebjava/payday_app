package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_updategeneral", "/web.cliente_updategeneral"})
public final  class cliente_updategeneral extends GXWebObjectStub
{
   public cliente_updategeneral( )
   {
   }

   public cliente_updategeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_updategeneral.class ));
   }

   public cliente_updategeneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_updategeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_updategeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente_Update General";
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

