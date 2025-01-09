package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajolicenciasview", "/web.legajolicenciasview"})
public final  class legajolicenciasview extends GXWebObjectStub
{
   public legajolicenciasview( )
   {
   }

   public legajolicenciasview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajolicenciasview.class ));
   }

   public legajolicenciasview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajolicenciasview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajolicenciasview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo Licencias View";
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

