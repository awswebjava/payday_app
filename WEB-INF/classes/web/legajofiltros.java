package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajofiltros", "/web.legajofiltros"})
public final  class legajofiltros extends GXWebObjectStub
{
   public legajofiltros( )
   {
   }

   public legajofiltros( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajofiltros.class ));
   }

   public legajofiltros( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajofiltros_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajofiltros_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Filtros";
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

