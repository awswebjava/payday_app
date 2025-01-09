package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_liquidacion_lsd", "/web.importacion_liquidacion_lsd"})
public final  class importacion_liquidacion_lsd extends GXWebObjectStub
{
   public importacion_liquidacion_lsd( )
   {
   }

   public importacion_liquidacion_lsd( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_liquidacion_lsd.class ));
   }

   public importacion_liquidacion_lsd( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_liquidacion_lsd_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_liquidacion_lsd_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_liquidacion_lsd";
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

