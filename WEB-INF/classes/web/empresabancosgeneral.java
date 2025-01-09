package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresabancosgeneral", "/web.empresabancosgeneral"})
public final  class empresabancosgeneral extends GXWebObjectStub
{
   public empresabancosgeneral( )
   {
   }

   public empresabancosgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresabancosgeneral.class ));
   }

   public empresabancosgeneral( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresabancosgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresabancosgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa Bancos General";
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

