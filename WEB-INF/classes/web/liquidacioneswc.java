package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacioneswc", "/web.liquidacioneswc"})
public final  class liquidacioneswc extends GXWebObjectStub
{
   public liquidacioneswc( )
   {
   }

   public liquidacioneswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacioneswc.class ));
   }

   public liquidacioneswc( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacioneswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacioneswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "liquidaciones WC";
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

