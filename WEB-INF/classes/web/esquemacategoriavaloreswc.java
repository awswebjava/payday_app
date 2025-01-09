package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemacategoriavaloreswc", "/web.esquemacategoriavaloreswc"})
public final  class esquemacategoriavaloreswc extends GXWebObjectStub
{
   public esquemacategoriavaloreswc( )
   {
   }

   public esquemacategoriavaloreswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemacategoriavaloreswc.class ));
   }

   public esquemacategoriavaloreswc( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemacategoriavaloreswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemacategoriavaloreswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Esquema Categoriavalores WC";
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

