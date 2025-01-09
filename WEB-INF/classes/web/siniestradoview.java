package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.siniestradoview", "/web.siniestradoview"})
public final  class siniestradoview extends GXWebObjectStub
{
   public siniestradoview( )
   {
   }

   public siniestradoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( siniestradoview.class ));
   }

   public siniestradoview( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new siniestradoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new siniestradoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Siniestrado View";
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

