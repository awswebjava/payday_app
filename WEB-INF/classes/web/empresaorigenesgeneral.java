package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresaorigenesgeneral", "/web.empresaorigenesgeneral"})
public final  class empresaorigenesgeneral extends GXWebObjectStub
{
   public empresaorigenesgeneral( )
   {
   }

   public empresaorigenesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresaorigenesgeneral.class ));
   }

   public empresaorigenesgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresaorigenesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresaorigenesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa Origenes General";
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

