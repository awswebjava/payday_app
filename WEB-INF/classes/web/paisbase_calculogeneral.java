package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisbase_calculogeneral", "/web.paisbase_calculogeneral"})
public final  class paisbase_calculogeneral extends GXWebObjectStub
{
   public paisbase_calculogeneral( )
   {
   }

   public paisbase_calculogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisbase_calculogeneral.class ));
   }

   public paisbase_calculogeneral( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisbase_calculogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisbase_calculogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Paisbase_calculo General";
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

