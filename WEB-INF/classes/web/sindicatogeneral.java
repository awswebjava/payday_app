package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sindicatogeneral", "/web.sindicatogeneral"})
public final  class sindicatogeneral extends GXWebObjectStub
{
   public sindicatogeneral( )
   {
   }

   public sindicatogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sindicatogeneral.class ));
   }

   public sindicatogeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sindicatogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sindicatogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sindicato General";
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

