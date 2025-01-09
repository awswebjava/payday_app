package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_conceptosview", "/web.importacion_conceptosview"})
public final  class importacion_conceptosview extends GXWebObjectStub
{
   public importacion_conceptosview( )
   {
   }

   public importacion_conceptosview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_conceptosview.class ));
   }

   public importacion_conceptosview( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_conceptosview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_conceptosview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_conceptos View";
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

