package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.artgeneral", "/web.artgeneral"})
public final  class artgeneral extends GXWebObjectStub
{
   public artgeneral( )
   {
   }

   public artgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( artgeneral.class ));
   }

   public artgeneral( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new artgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new artgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "ARTGeneral";
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

