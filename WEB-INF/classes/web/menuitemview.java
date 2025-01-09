package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.menuitemview", "/web.menuitemview"})
public final  class menuitemview extends GXWebObjectStub
{
   public menuitemview( )
   {
   }

   public menuitemview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menuitemview.class ));
   }

   public menuitemview( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menuitemview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menuitemview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Menu Item View";
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

