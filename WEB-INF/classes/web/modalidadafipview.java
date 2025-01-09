package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.modalidadafipview", "/web.modalidadafipview"})
public final  class modalidadafipview extends GXWebObjectStub
{
   public modalidadafipview( )
   {
   }

   public modalidadafipview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( modalidadafipview.class ));
   }

   public modalidadafipview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new modalidadafipview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new modalidadafipview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Modalidad AFIPView";
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

