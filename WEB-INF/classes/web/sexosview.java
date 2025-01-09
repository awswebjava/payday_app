package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sexosview", "/web.sexosview"})
public final  class sexosview extends GXWebObjectStub
{
   public sexosview( )
   {
   }

   public sexosview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sexosview.class ));
   }

   public sexosview( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sexosview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sexosview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sexos View";
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

