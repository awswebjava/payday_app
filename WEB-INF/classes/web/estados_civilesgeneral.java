package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.estados_civilesgeneral", "/web.estados_civilesgeneral"})
public final  class estados_civilesgeneral extends GXWebObjectStub
{
   public estados_civilesgeneral( )
   {
   }

   public estados_civilesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( estados_civilesgeneral.class ));
   }

   public estados_civilesgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new estados_civilesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new estados_civilesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Estados_civiles General";
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

