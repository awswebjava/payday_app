package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacionview", "/web.liquidacionview"})
public final  class liquidacionview extends GXWebObjectStub
{
   public liquidacionview( )
   {
   }

   public liquidacionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacionview.class ));
   }

   public liquidacionview( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidacion View";
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

