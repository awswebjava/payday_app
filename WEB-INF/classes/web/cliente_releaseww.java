package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.cliente_releaseww", "/web.cliente_releaseww"})
public final  class cliente_releaseww extends GXWebObjectStub
{
   public cliente_releaseww( )
   {
   }

   public cliente_releaseww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente_releaseww.class ));
   }

   public cliente_releaseww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_releaseww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_releaseww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Liberación de actualizaciones";
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

