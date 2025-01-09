package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.adicionalww", "/web.adicionalww"})
public final  class adicionalww extends GXWebObjectStub
{
   public adicionalww( )
   {
   }

   public adicionalww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( adicionalww.class ));
   }

   public adicionalww( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new adicionalww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new adicionalww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Adicional";
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

