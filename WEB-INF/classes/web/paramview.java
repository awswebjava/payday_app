package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paramview", "/web.paramview"})
public final  class paramview extends GXWebObjectStub
{
   public paramview( )
   {
   }

   public paramview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paramview.class ));
   }

   public paramview( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paramview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paramview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Param View";
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

