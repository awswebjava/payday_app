package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresareligiones", "/web.empresareligiones"})
public final  class empresareligiones extends GXWebObjectStub
{
   public empresareligiones( )
   {
   }

   public empresareligiones( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresareligiones.class ));
   }

   public empresareligiones( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresareligiones_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresareligiones_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa Religiones";
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

