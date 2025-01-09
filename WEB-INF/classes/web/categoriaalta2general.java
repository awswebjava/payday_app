package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.categoriaalta2general", "/web.categoriaalta2general"})
public final  class categoriaalta2general extends GXWebObjectStub
{
   public categoriaalta2general( )
   {
   }

   public categoriaalta2general( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categoriaalta2general.class ));
   }

   public categoriaalta2general( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categoriaalta2general_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categoriaalta2general_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Categoria Alta2 General";
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

