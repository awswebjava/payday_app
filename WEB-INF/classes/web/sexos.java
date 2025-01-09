package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sexos", "/web.sexos"})
public final  class sexos extends GXWebObjectStub
{
   public sexos( )
   {
   }

   public sexos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sexos.class ));
   }

   public sexos( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sexos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sexos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sexos";
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

