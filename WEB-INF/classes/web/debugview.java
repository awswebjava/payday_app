package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.debugview", "/web.debugview"})
public final  class debugview extends GXWebObjectStub
{
   public debugview( )
   {
   }

   public debugview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( debugview.class ));
   }

   public debugview( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new debugview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new debugview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Debug View";
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

