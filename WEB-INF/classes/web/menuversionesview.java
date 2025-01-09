package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.menuversionesview", "/web.menuversionesview"})
public final  class menuversionesview extends GXWebObjectStub
{
   public menuversionesview( )
   {
   }

   public menuversionesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menuversionesview.class ));
   }

   public menuversionesview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menuversionesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menuversionesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Menu Versiones View";
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

