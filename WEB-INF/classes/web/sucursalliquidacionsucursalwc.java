package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sucursalliquidacionsucursalwc", "/web.sucursalliquidacionsucursalwc"})
public final  class sucursalliquidacionsucursalwc extends GXWebObjectStub
{
   public sucursalliquidacionsucursalwc( )
   {
   }

   public sucursalliquidacionsucursalwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sucursalliquidacionsucursalwc.class ));
   }

   public sucursalliquidacionsucursalwc( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sucursalliquidacionsucursalwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sucursalliquidacionsucursalwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sucursal Liquidacion Sucursal WC";
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

