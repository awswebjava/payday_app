package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacion_export3", "/web.liquidacion_export3"})
public final  class liquidacion_export3 extends GXWebObjectStub
{
   public liquidacion_export3( )
   {
   }

   public liquidacion_export3( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacion_export3.class ));
   }

   public liquidacion_export3( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacion_export3_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacion_export3_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Detalle de liquidaciones";
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

