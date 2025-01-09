package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.motivoegresorevistaafipview", "/web.motivoegresorevistaafipview"})
public final  class motivoegresorevistaafipview extends GXWebObjectStub
{
   public motivoegresorevistaafipview( )
   {
   }

   public motivoegresorevistaafipview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivoegresorevistaafipview.class ));
   }

   public motivoegresorevistaafipview( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivoegresorevistaafipview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivoegresorevistaafipview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Egreso Revista Afip View";
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

