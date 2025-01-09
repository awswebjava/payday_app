package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.categoriaalta2valoreswc", "/web.categoriaalta2valoreswc"})
public final  class categoriaalta2valoreswc extends GXWebObjectStub
{
   public categoriaalta2valoreswc( )
   {
   }

   public categoriaalta2valoreswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categoriaalta2valoreswc.class ));
   }

   public categoriaalta2valoreswc( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categoriaalta2valoreswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categoriaalta2valoreswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Categoria Alta2valores WC";
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

