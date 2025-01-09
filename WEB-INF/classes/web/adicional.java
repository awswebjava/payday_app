package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.adicional", "/web.adicional"})
public final  class adicional extends GXWebObjectStub
{
   public adicional( )
   {
   }

   public adicional( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( adicional.class ));
   }

   public adicional( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new adicional_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new adicional_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Adicional";
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

