package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresabase_calculogeneral", "/web.empresabase_calculogeneral"})
public final  class empresabase_calculogeneral extends GXWebObjectStub
{
   public empresabase_calculogeneral( )
   {
   }

   public empresabase_calculogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresabase_calculogeneral.class ));
   }

   public empresabase_calculogeneral( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresabase_calculogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresabase_calculogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresabase_calculo General";
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
