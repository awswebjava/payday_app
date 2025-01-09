package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.mensajemigr", "/web.mensajemigr"})
public final  class mensajemigr extends GXWebObjectStub
{
   public mensajemigr( )
   {
   }

   public mensajemigr( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( mensajemigr.class ));
   }

   public mensajemigr( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new mensajemigr_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new mensajemigr_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Mensaje Migr";
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

