package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.modalidadafip", "/web.modalidadafip"})
public final  class modalidadafip extends GXWebObjectStub
{
   public modalidadafip( )
   {
   }

   public modalidadafip( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( modalidadafip.class ));
   }

   public modalidadafip( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new modalidadafip_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new modalidadafip_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Modalidad AFIP";
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
      return "modalidadpromovida_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

