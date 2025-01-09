package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.parentescogeneral", "/web.parentescogeneral"})
public final  class parentescogeneral extends GXWebObjectStub
{
   public parentescogeneral( )
   {
   }

   public parentescogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( parentescogeneral.class ));
   }

   public parentescogeneral( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new parentescogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new parentescogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Parentesco General";
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

