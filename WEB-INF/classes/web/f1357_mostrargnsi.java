package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.f1357_mostrargnsi", "/web.f1357_mostrargnsi"})
public final  class f1357_mostrargnsi extends GXWebObjectStub
{
   public f1357_mostrargnsi( )
   {
   }

   public f1357_mostrargnsi( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( f1357_mostrargnsi.class ));
   }

   public f1357_mostrargnsi( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new f1357_mostrargnsi_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new f1357_mostrargnsi_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Composición de GNSI";
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

