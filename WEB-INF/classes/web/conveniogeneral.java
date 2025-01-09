package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conveniogeneral", "/web.conveniogeneral"})
public final  class conveniogeneral extends GXWebObjectStub
{
   public conveniogeneral( )
   {
   }

   public conveniogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conveniogeneral.class ));
   }

   public conveniogeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conveniogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conveniogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Convenio General";
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

