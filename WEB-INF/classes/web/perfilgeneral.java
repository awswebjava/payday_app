package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.perfilgeneral", "/web.perfilgeneral"})
public final  class perfilgeneral extends GXWebObjectStub
{
   public perfilgeneral( )
   {
   }

   public perfilgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( perfilgeneral.class ));
   }

   public perfilgeneral( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new perfilgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new perfilgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Perfil General";
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

