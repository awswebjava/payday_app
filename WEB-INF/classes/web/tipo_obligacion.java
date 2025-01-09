package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_obligacion", "/web.tipo_obligacion"})
public final  class tipo_obligacion extends GXWebObjectStub
{
   public tipo_obligacion( )
   {
   }

   public tipo_obligacion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_obligacion.class ));
   }

   public tipo_obligacion( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_obligacion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_obligacion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "tipo_obligacion";
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

