package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condicion_exencion_iigggeneral", "/web.condicion_exencion_iigggeneral"})
public final  class condicion_exencion_iigggeneral extends GXWebObjectStub
{
   public condicion_exencion_iigggeneral( )
   {
   }

   public condicion_exencion_iigggeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condicion_exencion_iigggeneral.class ));
   }

   public condicion_exencion_iigggeneral( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condicion_exencion_iigggeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condicion_exencion_iigggeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "condicion_exencion_iigg General";
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

