package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.menuversionesgeneral", "/web.menuversionesgeneral"})
public final  class menuversionesgeneral extends GXWebObjectStub
{
   public menuversionesgeneral( )
   {
   }

   public menuversionesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menuversionesgeneral.class ));
   }

   public menuversionesgeneral( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menuversionesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menuversionesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Menu Versiones General";
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

