package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sucursallegajoswc", "/web.sucursallegajoswc"})
public final  class sucursallegajoswc extends GXWebObjectStub
{
   public sucursallegajoswc( )
   {
   }

   public sucursallegajoswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sucursallegajoswc.class ));
   }

   public sucursallegajoswc( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sucursallegajoswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sucursallegajoswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sucursal Legajos WC";
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

