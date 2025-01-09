package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresaorigenes", "/web.empresaorigenes"})
public final  class empresaorigenes extends GXWebObjectStub
{
   public empresaorigenes( )
   {
   }

   public empresaorigenes( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresaorigenes.class ));
   }

   public empresaorigenes( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresaorigenes_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresaorigenes_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa Origenes";
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

