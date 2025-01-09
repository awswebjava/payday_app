package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.origenview", "/web.origenview"})
public final  class origenview extends GXWebObjectStub
{
   public origenview( )
   {
   }

   public origenview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( origenview.class ));
   }

   public origenview( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new origenview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new origenview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Origen View";
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

