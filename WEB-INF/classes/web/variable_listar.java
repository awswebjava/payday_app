package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variable_listar", "/web.variable_listar"})
public final  class variable_listar extends GXWebObjectStub
{
   public variable_listar( )
   {
   }

   public variable_listar( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variable_listar.class ));
   }

   public variable_listar( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variable_listar_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variable_listar_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable_listar";
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

