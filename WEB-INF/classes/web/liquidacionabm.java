package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionabm", "/web.liquidacionabm"})
public final  class liquidacionabm extends GXWebObjectStub
{
   public liquidacionabm( )
   {
   }

   public liquidacionabm( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionabm.class ));
   }

   public liquidacionabm( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionabm_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionabm_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion ABM";
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

