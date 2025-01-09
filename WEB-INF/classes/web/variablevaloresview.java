package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variablevaloresview", "/web.variablevaloresview"})
public final  class variablevaloresview extends GXWebObjectStub
{
   public variablevaloresview( )
   {
   }

   public variablevaloresview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variablevaloresview.class ));
   }

   public variablevaloresview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variablevaloresview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variablevaloresview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable Valores View";
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

