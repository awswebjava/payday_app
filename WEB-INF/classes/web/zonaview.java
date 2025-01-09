package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.zonaview", "/web.zonaview"})
public final  class zonaview extends GXWebObjectStub
{
   public zonaview( )
   {
   }

   public zonaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( zonaview.class ));
   }

   public zonaview( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new zonaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new zonaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Zona View";
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

