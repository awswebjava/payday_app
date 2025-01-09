package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionlegajowc", "/web.liquidacionlegajowc"})
public final  class liquidacionlegajowc extends GXWebObjectStub
{
   public liquidacionlegajowc( )
   {
   }

   public liquidacionlegajowc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionlegajowc.class ));
   }

   public liquidacionlegajowc( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionlegajowc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionlegajowc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion Legajo WC";
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

