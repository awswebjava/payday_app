package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.perfil", "/web.perfil"})
public final  class perfil extends GXWebObjectStub
{
   public perfil( )
   {
   }

   public perfil( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( perfil.class ));
   }

   public perfil( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new perfil_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new perfil_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Perfil";
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
