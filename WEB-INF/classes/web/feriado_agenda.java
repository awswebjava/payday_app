package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.feriado_agenda", "/web.feriado_agenda"})
public final  class feriado_agenda extends GXWebObjectStub
{
   public feriado_agenda( )
   {
   }

   public feriado_agenda( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( feriado_agenda.class ));
   }

   public feriado_agenda( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new feriado_agenda_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new feriado_agenda_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Feriado agenda";
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

