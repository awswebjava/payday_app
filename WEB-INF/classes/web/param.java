package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.param", "/web.param"})
public final  class param extends GXWebObjectStub
{
   public param( )
   {
   }

   public param( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( param.class ));
   }

   public param( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new param_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new param_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Valores Predeterminados y Otros Parámetros";
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

