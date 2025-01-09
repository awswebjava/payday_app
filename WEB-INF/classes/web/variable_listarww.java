package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variable_listarww", "/web.variable_listarww"})
public final  class variable_listarww extends GXWebObjectStub
{
   public variable_listarww( )
   {
   }

   public variable_listarww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variable_listarww.class ));
   }

   public variable_listarww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variable_listarww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variable_listarww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variables";
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

