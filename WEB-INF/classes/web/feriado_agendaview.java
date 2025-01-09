package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.feriado_agendaview", "/web.feriado_agendaview"})
public final  class feriado_agendaview extends GXWebObjectStub
{
   public feriado_agendaview( )
   {
   }

   public feriado_agendaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( feriado_agendaview.class ));
   }

   public feriado_agendaview( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new feriado_agendaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new feriado_agendaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "feriado_agenda View";
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

