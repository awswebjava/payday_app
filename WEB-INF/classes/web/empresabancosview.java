package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresabancosview", "/web.empresabancosview"})
public final  class empresabancosview extends GXWebObjectStub
{
   public empresabancosview( )
   {
   }

   public empresabancosview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresabancosview.class ));
   }

   public empresabancosview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresabancosview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresabancosview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa Bancos View";
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

