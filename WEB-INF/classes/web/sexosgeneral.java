package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sexosgeneral", "/web.sexosgeneral"})
public final  class sexosgeneral extends GXWebObjectStub
{
   public sexosgeneral( )
   {
   }

   public sexosgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sexosgeneral.class ));
   }

   public sexosgeneral( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sexosgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sexosgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sexos General";
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

