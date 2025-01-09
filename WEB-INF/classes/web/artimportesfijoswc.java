package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.artimportesfijoswc", "/web.artimportesfijoswc"})
public final  class artimportesfijoswc extends GXWebObjectStub
{
   public artimportesfijoswc( )
   {
   }

   public artimportesfijoswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( artimportesfijoswc.class ));
   }

   public artimportesfijoswc( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new artimportesfijoswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new artimportesfijoswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "ARTImportes Fijos WC";
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

