package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obligacionview", "/web.obligacionview"})
public final  class obligacionview extends GXWebObjectStub
{
   public obligacionview( )
   {
   }

   public obligacionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obligacionview.class ));
   }

   public obligacionview( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obligacionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obligacionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Obligacion View";
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

