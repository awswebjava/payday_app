package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variablevalores", "/web.variablevalores"})
public final  class variablevalores extends GXWebObjectStub
{
   public variablevalores( )
   {
   }

   public variablevalores( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variablevalores.class ));
   }

   public variablevalores( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variablevalores_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variablevalores_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable Valores";
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

