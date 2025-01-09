package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.rolusuarioww", "/web.rolusuarioww"})
public final  class rolusuarioww extends GXWebObjectStub
{
   public rolusuarioww( )
   {
   }

   public rolusuarioww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rolusuarioww.class ));
   }

   public rolusuarioww( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rolusuarioww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rolusuarioww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Rol Usuario";
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

