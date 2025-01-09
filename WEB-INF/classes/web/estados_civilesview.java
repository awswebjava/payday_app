package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.estados_civilesview", "/web.estados_civilesview"})
public final  class estados_civilesview extends GXWebObjectStub
{
   public estados_civilesview( )
   {
   }

   public estados_civilesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( estados_civilesview.class ));
   }

   public estados_civilesview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new estados_civilesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new estados_civilesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Estados_civiles View";
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

