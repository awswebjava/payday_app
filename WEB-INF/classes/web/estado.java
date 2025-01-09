package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.estado", "/web.estado"})
public final  class estado extends GXWebObjectStub
{
   public estado( )
   {
   }

   public estado( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( estado.class ));
   }

   public estado( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new estado_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new estado_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Situaciones de revista / Licencias";
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

