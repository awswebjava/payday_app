package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.ajustesporinflacion", "/web.ajustesporinflacion"})
public final  class ajustesporinflacion extends GXWebObjectStub
{
   public ajustesporinflacion( )
   {
   }

   public ajustesporinflacion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ajustesporinflacion.class ));
   }

   public ajustesporinflacion( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ajustesporinflacion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ajustesporinflacion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Ajuste de sueldos por inflación";
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

