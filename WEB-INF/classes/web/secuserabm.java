package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.secuserabm", "/web.secuserabm"})
public final  class secuserabm extends GXWebObjectStub
{
   public secuserabm( )
   {
   }

   public secuserabm( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secuserabm.class ));
   }

   public secuserabm( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secuserabm_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secuserabm_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec User ABM";
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
