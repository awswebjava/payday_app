package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.periodocardsview", "/web.periodocardsview"})
public final  class periodocardsview extends GXWebObjectStub
{
   public periodocardsview( )
   {
   }

   public periodocardsview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( periodocardsview.class ));
   }

   public periodocardsview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new periodocardsview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new periodocardsview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Periodo Cards View";
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

