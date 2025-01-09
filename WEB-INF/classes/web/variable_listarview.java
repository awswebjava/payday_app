package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variable_listarview", "/web.variable_listarview"})
public final  class variable_listarview extends GXWebObjectStub
{
   public variable_listarview( )
   {
   }

   public variable_listarview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variable_listarview.class ));
   }

   public variable_listarview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variable_listarview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variable_listarview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable_listar View";
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

