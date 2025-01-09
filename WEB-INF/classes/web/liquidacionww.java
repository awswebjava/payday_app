package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionww", "/web.liquidacionww"})
public final  class liquidacionww extends GXWebObjectStub
{
   public liquidacionww( )
   {
   }

   public liquidacionww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionww.class ));
   }

   public liquidacionww( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Liquidaciones";
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

