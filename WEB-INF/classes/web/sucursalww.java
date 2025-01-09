package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sucursalww", "/web.sucursalww"})
public final  class sucursalww extends GXWebObjectStub
{
   public sucursalww( )
   {
   }

   public sucursalww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sucursalww.class ));
   }

   public sucursalww( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sucursalww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sucursalww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Sucursal";
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

