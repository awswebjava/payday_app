package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemahorasextras", "/web.esquemahorasextras"})
public final  class esquemahorasextras extends GXWebObjectStub
{
   public esquemahorasextras( )
   {
   }

   public esquemahorasextras( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemahorasextras.class ));
   }

   public esquemahorasextras( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemahorasextras_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemahorasextras_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Esquema Horas Extras";
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

