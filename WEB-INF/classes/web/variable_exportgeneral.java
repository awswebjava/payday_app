package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variable_exportgeneral", "/web.variable_exportgeneral"})
public final  class variable_exportgeneral extends GXWebObjectStub
{
   public variable_exportgeneral( )
   {
   }

   public variable_exportgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variable_exportgeneral.class ));
   }

   public variable_exportgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variable_exportgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variable_exportgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable_export General";
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

