package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_legajoview", "/web.importacion_legajoview"})
public final  class importacion_legajoview extends GXWebObjectStub
{
   public importacion_legajoview( )
   {
   }

   public importacion_legajoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_legajoview.class ));
   }

   public importacion_legajoview( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_legajoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_legajoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_legajo View";
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

