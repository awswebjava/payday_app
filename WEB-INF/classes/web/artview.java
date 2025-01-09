package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.artview", "/web.artview"})
public final  class artview extends GXWebObjectStub
{
   public artview( )
   {
   }

   public artview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( artview.class ));
   }

   public artview( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new artview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new artview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "ARTView";
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

