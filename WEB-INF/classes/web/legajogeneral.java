package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajogeneral", "/web.legajogeneral"})
public final  class legajogeneral extends GXWebObjectStub
{
   public legajogeneral( )
   {
   }

   public legajogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajogeneral.class ));
   }

   public legajogeneral( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo General";
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

