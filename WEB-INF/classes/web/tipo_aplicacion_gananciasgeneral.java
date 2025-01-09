package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_aplicacion_gananciasgeneral", "/web.tipo_aplicacion_gananciasgeneral"})
public final  class tipo_aplicacion_gananciasgeneral extends GXWebObjectStub
{
   public tipo_aplicacion_gananciasgeneral( )
   {
   }

   public tipo_aplicacion_gananciasgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_aplicacion_gananciasgeneral.class ));
   }

   public tipo_aplicacion_gananciasgeneral( int remoteHandle ,
                                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_aplicacion_gananciasgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_aplicacion_gananciasgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "tipo_aplicacion_ganancias General";
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

