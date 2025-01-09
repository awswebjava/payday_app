package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.subirarchivosiradig", "/web.subirarchivosiradig"})
public final  class subirarchivosiradig extends GXWebObjectStub
{
   public subirarchivosiradig( )
   {
   }

   public subirarchivosiradig( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( subirarchivosiradig.class ));
   }

   public subirarchivosiradig( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new subirarchivosiradig_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new subirarchivosiradig_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Subir Archivo Siradig";
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

