package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.home_temp", "/web.home_temp"})
public final  class home_temp extends GXWebObjectStub
{
   public home_temp( )
   {
   }

   public home_temp( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( home_temp.class ));
   }

   public home_temp( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new home_temp_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new home_temp_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Home";
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

