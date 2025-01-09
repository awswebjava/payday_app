package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.motivoegresorevistaafipmotivoegreso", "/web.motivoegresorevistaafipmotivoegreso"})
public final  class motivoegresorevistaafipmotivoegreso extends GXWebObjectStub
{
   public motivoegresorevistaafipmotivoegreso( )
   {
   }

   public motivoegresorevistaafipmotivoegreso( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivoegresorevistaafipmotivoegreso.class ));
   }

   public motivoegresorevistaafipmotivoegreso( int remoteHandle ,
                                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivoegresorevistaafipmotivoegreso_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivoegresorevistaafipmotivoegreso_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Egreso Revista Afip Motivo Egreso";
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

