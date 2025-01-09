package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisvacaciones", "/web.paisvacaciones"})
public final  class paisvacaciones extends GXWebObjectStub
{
   public paisvacaciones( )
   {
   }

   public paisvacaciones( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisvacaciones.class ));
   }

   public paisvacaciones( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisvacaciones_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisvacaciones_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Vacaciones";
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

