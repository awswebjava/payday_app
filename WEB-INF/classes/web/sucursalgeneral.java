package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sucursalgeneral", "/web.sucursalgeneral"})
public final  class sucursalgeneral extends GXWebObjectStub
{
   public sucursalgeneral( )
   {
   }

   public sucursalgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sucursalgeneral.class ));
   }

   public sucursalgeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sucursalgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sucursalgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sucursal General";
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

