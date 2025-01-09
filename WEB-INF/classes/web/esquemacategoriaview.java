package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemacategoriaview", "/web.esquemacategoriaview"})
public final  class esquemacategoriaview extends GXWebObjectStub
{
   public esquemacategoriaview( )
   {
   }

   public esquemacategoriaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemacategoriaview.class ));
   }

   public esquemacategoriaview( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemacategoriaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemacategoriaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Esquema Categoria View";
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

