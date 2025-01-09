package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.feriado_agendaww", "/web.feriado_agendaww"})
public final  class feriado_agendaww extends GXWebObjectStub
{
   public feriado_agendaww( )
   {
   }

   public feriado_agendaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( feriado_agendaww.class ));
   }

   public feriado_agendaww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new feriado_agendaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new feriado_agendaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Feriados agenda";
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

