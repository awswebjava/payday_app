package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.debugww", "/web.debugww"})
public final  class debugww extends GXWebObjectStub
{
   public debugww( )
   {
   }

   public debugww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( debugww.class ));
   }

   public debugww( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new debugww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new debugww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Debug";
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

