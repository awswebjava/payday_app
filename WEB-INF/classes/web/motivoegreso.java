package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.motivoegreso", "/web.motivoegreso"})
public final  class motivoegreso extends GXWebObjectStub
{
   public motivoegreso( )
   {
   }

   public motivoegreso( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivoegreso.class ));
   }

   public motivoegreso( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivoegreso_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivoegreso_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Egreso";
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
      return "motivoegreso_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

