package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.feriado_agendageneral", "/web.feriado_agendageneral"})
public final  class feriado_agendageneral extends GXWebObjectStub
{
   public feriado_agendageneral( )
   {
   }

   public feriado_agendageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( feriado_agendageneral.class ));
   }

   public feriado_agendageneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new feriado_agendageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new feriado_agendageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "feriado_agenda General";
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

