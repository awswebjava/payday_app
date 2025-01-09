package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_permanenciageneral", "/web.legajo_permanenciageneral"})
public final  class legajo_permanenciageneral extends GXWebObjectStub
{
   public legajo_permanenciageneral( )
   {
   }

   public legajo_permanenciageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_permanenciageneral.class ));
   }

   public legajo_permanenciageneral( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_permanenciageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_permanenciageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "legajo_permanencia General";
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

