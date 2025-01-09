package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secuser", "/web.wwpbaseobjects.secuser"})
public final  class secuser extends GXWebObjectStub
{
   public secuser( )
   {
   }

   public secuser( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secuser.class ));
   }

   public secuser( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secuser_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secuser_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "User";
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

