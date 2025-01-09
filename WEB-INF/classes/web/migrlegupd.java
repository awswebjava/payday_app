package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.migrlegupd", "/web.migrlegupd"})
public final  class migrlegupd extends GXWebObjectStub
{
   public migrlegupd( )
   {
   }

   public migrlegupd( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( migrlegupd.class ));
   }

   public migrlegupd( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new migrlegupd_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new migrlegupd_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Importación de Legajos";
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

