package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.puestogeneral", "/web.puestogeneral"})
public final  class puestogeneral extends GXWebObjectStub
{
   public puestogeneral( )
   {
   }

   public puestogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( puestogeneral.class ));
   }

   public puestogeneral( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new puestogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new puestogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Puesto General";
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

