package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.categoriaalta2ww", "/web.categoriaalta2ww"})
public final  class categoriaalta2ww extends GXWebObjectStub
{
   public categoriaalta2ww( )
   {
   }

   public categoriaalta2ww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categoriaalta2ww.class ));
   }

   public categoriaalta2ww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categoriaalta2ww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categoriaalta2ww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Categoria Alta";
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

