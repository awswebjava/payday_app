package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variable_valores", "/web.variable_valores"})
public final  class variable_valores extends GXWebObjectStub
{
   public variable_valores( )
   {
   }

   public variable_valores( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variable_valores.class ));
   }

   public variable_valores( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variable_valores_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variable_valores_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "variable_valores";
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

