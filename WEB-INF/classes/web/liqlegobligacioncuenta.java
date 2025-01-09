package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liqlegobligacioncuenta", "/web.liqlegobligacioncuenta"})
public final  class liqlegobligacioncuenta extends GXWebObjectStub
{
   public liqlegobligacioncuenta( )
   {
   }

   public liqlegobligacioncuenta( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liqlegobligacioncuenta.class ));
   }

   public liqlegobligacioncuenta( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liqlegobligacioncuenta_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liqlegobligacioncuenta_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liq Leg Obligacion Cuenta";
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

