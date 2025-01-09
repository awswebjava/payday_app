package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secfunctionalityrole", "/web.wwpbaseobjects.secfunctionalityrole"})
public final  class secfunctionalityrole extends GXWebObjectStub
{
   public secfunctionalityrole( )
   {
   }

   public secfunctionalityrole( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secfunctionalityrole.class ));
   }

   public secfunctionalityrole( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secfunctionalityrole_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secfunctionalityrole_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Functionality - Role";
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

