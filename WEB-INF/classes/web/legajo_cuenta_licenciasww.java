package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_cuenta_licenciasww", "/web.legajo_cuenta_licenciasww"})
public final  class legajo_cuenta_licenciasww extends GXWebObjectStub
{
   public legajo_cuenta_licenciasww( )
   {
   }

   public legajo_cuenta_licenciasww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_cuenta_licenciasww.class ));
   }

   public legajo_cuenta_licenciasww( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_cuenta_licenciasww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_cuenta_licenciasww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " legajo_cuenta_licencias";
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

