package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.estados_civilesww", "/web.estados_civilesww"})
public final  class estados_civilesww extends GXWebObjectStub
{
   public estados_civilesww( )
   {
   }

   public estados_civilesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( estados_civilesww.class ));
   }

   public estados_civilesww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new estados_civilesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new estados_civilesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Estados_civiles";
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

