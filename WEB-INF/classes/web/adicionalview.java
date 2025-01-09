package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.adicionalview", "/web.adicionalview"})
public final  class adicionalview extends GXWebObjectStub
{
   public adicionalview( )
   {
   }

   public adicionalview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( adicionalview.class ));
   }

   public adicionalview( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new adicionalview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new adicionalview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Adicional View";
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

