package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.debuggeneral", "/web.debuggeneral"})
public final  class debuggeneral extends GXWebObjectStub
{
   public debuggeneral( )
   {
   }

   public debuggeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( debuggeneral.class ));
   }

   public debuggeneral( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new debuggeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new debuggeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Debug General";
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

