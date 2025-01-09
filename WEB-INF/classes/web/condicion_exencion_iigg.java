package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condicion_exencion_iigg", "/web.condicion_exencion_iigg"})
public final  class condicion_exencion_iigg extends GXWebObjectStub
{
   public condicion_exencion_iigg( )
   {
   }

   public condicion_exencion_iigg( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condicion_exencion_iigg.class ));
   }

   public condicion_exencion_iigg( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condicion_exencion_iigg_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condicion_exencion_iigg_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "condicion_exencion_iigg";
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

