package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.feriadoview", "/web.feriadoview"})
public final  class feriadoview extends GXWebObjectStub
{
   public feriadoview( )
   {
   }

   public feriadoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( feriadoview.class ));
   }

   public feriadoview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new feriadoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new feriadoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "feriado View";
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

