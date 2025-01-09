package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.soap_locationgeneral", "/web.soap_locationgeneral"})
public final  class soap_locationgeneral extends GXWebObjectStub
{
   public soap_locationgeneral( )
   {
   }

   public soap_locationgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( soap_locationgeneral.class ));
   }

   public soap_locationgeneral( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new soap_locationgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new soap_locationgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "soap_location General";
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

