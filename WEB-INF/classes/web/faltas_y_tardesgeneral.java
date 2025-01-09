package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.faltas_y_tardesgeneral", "/web.faltas_y_tardesgeneral"})
public final  class faltas_y_tardesgeneral extends GXWebObjectStub
{
   public faltas_y_tardesgeneral( )
   {
   }

   public faltas_y_tardesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( faltas_y_tardesgeneral.class ));
   }

   public faltas_y_tardesgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new faltas_y_tardesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new faltas_y_tardesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "faltas_y_tardes General";
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

