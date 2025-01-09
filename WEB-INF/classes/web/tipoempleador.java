package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoempleador", "/web.tipoempleador"})
public final  class tipoempleador extends GXWebObjectStub
{
   public tipoempleador( )
   {
   }

   public tipoempleador( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoempleador.class ));
   }

   public tipoempleador( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoempleador_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoempleador_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Empleador";
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

