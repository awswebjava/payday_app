package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionajuste", "/web.liquidacionajuste"})
public final  class liquidacionajuste extends GXWebObjectStub
{
   public liquidacionajuste( )
   {
   }

   public liquidacionajuste( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionajuste.class ));
   }

   public liquidacionajuste( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionajuste_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionajuste_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion Ajuste";
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

