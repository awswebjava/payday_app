package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.newmasterpage", "/web.wwpbaseobjects.newmasterpage"})
public final  class newmasterpage extends GXWebObjectStub
{
   public newmasterpage( )
   {
   }

   public newmasterpage( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( newmasterpage.class ));
   }

   public newmasterpage( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new newmasterpage_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new newmasterpage_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Master Page";
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

