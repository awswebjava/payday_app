package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_legajoww", "/web.importacion_legajoww"})
public final  class importacion_legajoww extends GXWebObjectStub
{
   public importacion_legajoww( )
   {
   }

   public importacion_legajoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_legajoww.class ));
   }

   public importacion_legajoww( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_legajoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_legajoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Importación de Legajos";
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

