package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.provinciageneral", "/web.provinciageneral"})
public final  class provinciageneral extends GXWebObjectStub
{
   public provinciageneral( )
   {
   }

   public provinciageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( provinciageneral.class ));
   }

   public provinciageneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new provinciageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new provinciageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Provincia General";
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

