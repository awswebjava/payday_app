package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sucursallegajowc", "/web.sucursallegajowc"})
public final  class sucursallegajowc extends GXWebObjectStub
{
   public sucursallegajowc( )
   {
   }

   public sucursallegajowc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sucursallegajowc.class ));
   }

   public sucursallegajowc( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sucursallegajowc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sucursallegajowc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sucursal Legajo WC";
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

