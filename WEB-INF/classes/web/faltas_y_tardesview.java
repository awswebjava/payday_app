package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.faltas_y_tardesview", "/web.faltas_y_tardesview"})
public final  class faltas_y_tardesview extends GXWebObjectStub
{
   public faltas_y_tardesview( )
   {
   }

   public faltas_y_tardesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( faltas_y_tardesview.class ));
   }

   public faltas_y_tardesview( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new faltas_y_tardesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new faltas_y_tardesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "faltas_y_tardes View";
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

