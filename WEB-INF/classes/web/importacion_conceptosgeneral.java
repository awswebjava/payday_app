package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_conceptosgeneral", "/web.importacion_conceptosgeneral"})
public final  class importacion_conceptosgeneral extends GXWebObjectStub
{
   public importacion_conceptosgeneral( )
   {
   }

   public importacion_conceptosgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_conceptosgeneral.class ));
   }

   public importacion_conceptosgeneral( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_conceptosgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_conceptosgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_conceptos General";
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

