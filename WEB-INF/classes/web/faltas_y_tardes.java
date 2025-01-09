package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.faltas_y_tardes", "/web.faltas_y_tardes"})
public final  class faltas_y_tardes extends GXWebObjectStub
{
   public faltas_y_tardes( )
   {
   }

   public faltas_y_tardes( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( faltas_y_tardes.class ));
   }

   public faltas_y_tardes( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new faltas_y_tardes_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new faltas_y_tardes_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Novedad Eventos";
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

