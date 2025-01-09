package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.nuevousuario", "/web.nuevousuario"})
public final  class nuevousuario extends GXWebObjectStub
{
   public nuevousuario( )
   {
   }

   public nuevousuario( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( nuevousuario.class ));
   }

   public nuevousuario( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new nuevousuario_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new nuevousuario_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Nuevo Usuario";
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

