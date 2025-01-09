package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_legajogeneral", "/web.importacion_legajogeneral"})
public final  class importacion_legajogeneral extends GXWebObjectStub
{
   public importacion_legajogeneral( )
   {
   }

   public importacion_legajogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_legajogeneral.class ));
   }

   public importacion_legajogeneral( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_legajogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_legajogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_legajo General";
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

