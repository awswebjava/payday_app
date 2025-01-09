package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.adownload", "/web.adownload"})
public final  class adownload extends GXWebObjectStub
{
   public adownload( )
   {
   }

   public adownload( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( adownload.class ));
   }

   public adownload( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new adownload_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new adownload_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "download";
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

