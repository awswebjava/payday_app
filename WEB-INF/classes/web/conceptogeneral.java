package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptogeneral", "/web.conceptogeneral"})
public final  class conceptogeneral extends GXWebObjectStub
{
   public conceptogeneral( )
   {
   }

   public conceptogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptogeneral.class ));
   }

   public conceptogeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto General";
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

