package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.gethomesampledataservice", "/web.wwpbaseobjects.gethomesampledataservice"})
public final  class gethomesampledataservice extends GXWebObjectStub
{
   public gethomesampledataservice( )
   {
   }

   public gethomesampledataservice( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gethomesampledataservice.class ));
   }

   public gethomesampledataservice( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gethomesampledataservice_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gethomesampledataservice_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Get Home Sample Data Service";
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

