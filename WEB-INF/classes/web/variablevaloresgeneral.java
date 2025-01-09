package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variablevaloresgeneral", "/web.variablevaloresgeneral"})
public final  class variablevaloresgeneral extends GXWebObjectStub
{
   public variablevaloresgeneral( )
   {
   }

   public variablevaloresgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variablevaloresgeneral.class ));
   }

   public variablevaloresgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variablevaloresgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variablevaloresgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable Valores General";
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

