package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.bancogeneral", "/web.bancogeneral"})
public final  class bancogeneral extends GXWebObjectStub
{
   public bancogeneral( )
   {
   }

   public bancogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( bancogeneral.class ));
   }

   public bancogeneral( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new bancogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new bancogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Banco General";
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

