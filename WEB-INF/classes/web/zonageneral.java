package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.zonageneral", "/web.zonageneral"})
public final  class zonageneral extends GXWebObjectStub
{
   public zonageneral( )
   {
   }

   public zonageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( zonageneral.class ));
   }

   public zonageneral( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new zonageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new zonageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Zona General";
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

