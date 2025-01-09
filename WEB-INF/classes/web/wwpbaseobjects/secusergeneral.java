package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secusergeneral", "/web.wwpbaseobjects.secusergeneral"})
public final  class secusergeneral extends GXWebObjectStub
{
   public secusergeneral( )
   {
   }

   public secusergeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secusergeneral.class ));
   }

   public secusergeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secusergeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secusergeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec User General";
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

