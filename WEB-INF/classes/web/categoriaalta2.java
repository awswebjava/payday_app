package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.categoriaalta2", "/web.categoriaalta2"})
public final  class categoriaalta2 extends GXWebObjectStub
{
   public categoriaalta2( )
   {
   }

   public categoriaalta2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categoriaalta2.class ));
   }

   public categoriaalta2( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categoriaalta2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categoriaalta2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Categoria Alta";
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
      return "categoria_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

