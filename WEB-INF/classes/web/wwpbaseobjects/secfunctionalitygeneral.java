package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secfunctionalitygeneral", "/web.wwpbaseobjects.secfunctionalitygeneral"})
public final  class secfunctionalitygeneral extends GXWebObjectStub
{
   public secfunctionalitygeneral( )
   {
   }

   public secfunctionalitygeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secfunctionalitygeneral.class ));
   }

   public secfunctionalitygeneral( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secfunctionalitygeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secfunctionalitygeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec Functionality General";
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

