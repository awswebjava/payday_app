package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_releasegeneral", "/web.cliente_releasegeneral"})
public final  class cliente_releasegeneral extends GXWebObjectStub
{
   public cliente_releasegeneral( )
   {
   }

   public cliente_releasegeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_releasegeneral.class ));
   }

   public cliente_releasegeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_releasegeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_releasegeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente_Release General";
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

