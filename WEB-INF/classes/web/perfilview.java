package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.perfilview", "/web.perfilview"})
public final  class perfilview extends GXWebObjectStub
{
   public perfilview( )
   {
   }

   public perfilview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( perfilview.class ));
   }

   public perfilview( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new perfilview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new perfilview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Perfil View";
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

