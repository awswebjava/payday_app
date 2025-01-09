package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importlsd2", "/web.importlsd2"})
public final  class importlsd2 extends GXWebObjectStub
{
   public importlsd2( )
   {
   }

   public importlsd2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importlsd2.class ));
   }

   public importlsd2( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importlsd2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importlsd2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " importacion_liquidacion_detalle";
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

