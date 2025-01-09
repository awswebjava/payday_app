package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.secciongeneral", "/web.secciongeneral"})
public final  class secciongeneral extends GXWebObjectStub
{
   public secciongeneral( )
   {
   }

   public secciongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secciongeneral.class ));
   }

   public secciongeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secciongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secciongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Seccion General";
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

