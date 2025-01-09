package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_conceptos", "/web.importacion_conceptos"})
public final  class importacion_conceptos extends GXWebObjectStub
{
   public importacion_conceptos( )
   {
   }

   public importacion_conceptos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_conceptos.class ));
   }

   public importacion_conceptos( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_conceptos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_conceptos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_conceptos";
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

