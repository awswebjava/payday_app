package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresaorigenesview", "/web.empresaorigenesview"})
public final  class empresaorigenesview extends GXWebObjectStub
{
   public empresaorigenesview( )
   {
   }

   public empresaorigenesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresaorigenesview.class ));
   }

   public empresaorigenesview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresaorigenesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresaorigenesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa Origenes View";
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

