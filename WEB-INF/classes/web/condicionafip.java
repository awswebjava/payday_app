package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condicionafip", "/web.condicionafip"})
public final  class condicionafip extends GXWebObjectStub
{
   public condicionafip( )
   {
   }

   public condicionafip( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condicionafip.class ));
   }

   public condicionafip( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condicionafip_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condicionafip_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Condicion AFIP";
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

