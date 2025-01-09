package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.activarusuario", "/web.activarusuario"})
public final  class activarusuario extends GXWebObjectStub
{
   public activarusuario( )
   {
   }

   public activarusuario( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( activarusuario.class ));
   }

   public activarusuario( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new activarusuario_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new activarusuario_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Activar Usuario";
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

