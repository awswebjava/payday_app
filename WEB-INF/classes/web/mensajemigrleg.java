package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.mensajemigrleg", "/web.mensajemigrleg"})
public final  class mensajemigrleg extends GXWebObjectStub
{
   public mensajemigrleg( )
   {
   }

   public mensajemigrleg( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( mensajemigrleg.class ));
   }

   public mensajemigrleg( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new mensajemigrleg_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new mensajemigrleg_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Mensaje Migr Leg";
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

