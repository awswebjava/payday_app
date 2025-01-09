package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_tiposdetrabajo", "/web.empresa_tiposdetrabajo"})
public final  class empresa_tiposdetrabajo extends GXWebObjectStub
{
   public empresa_tiposdetrabajo( )
   {
   }

   public empresa_tiposdetrabajo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_tiposdetrabajo.class ));
   }

   public empresa_tiposdetrabajo( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_tiposdetrabajo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_tiposdetrabajo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "empresa_tiposdetrabajo";
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

