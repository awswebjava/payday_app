package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obligacion", "/web.obligacion"})
public final  class obligacion extends GXWebObjectStub
{
   public obligacion( )
   {
   }

   public obligacion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obligacion.class ));
   }

   public obligacion( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obligacion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obligacion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Obligacion";
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

