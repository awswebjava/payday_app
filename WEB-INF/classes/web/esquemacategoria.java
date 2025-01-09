package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemacategoria", "/web.esquemacategoria"})
public final  class esquemacategoria extends GXWebObjectStub
{
   public esquemacategoria( )
   {
   }

   public esquemacategoria( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemacategoria.class ));
   }

   public esquemacategoria( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemacategoria_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemacategoria_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Esquema Categoria";
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

