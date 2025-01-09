package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.categoriaview", "/web.categoriaview"})
public final  class categoriaview extends GXWebObjectStub
{
   public categoriaview( )
   {
   }

   public categoriaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categoriaview.class ));
   }

   public categoriaview( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categoriaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categoriaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Categoria View";
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

