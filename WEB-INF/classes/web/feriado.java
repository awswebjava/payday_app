package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.feriado", "/web.feriado"})
public final  class feriado extends GXWebObjectStub
{
   public feriado( )
   {
   }

   public feriado( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( feriado.class ));
   }

   public feriado( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new feriado_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new feriado_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "feriado";
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

