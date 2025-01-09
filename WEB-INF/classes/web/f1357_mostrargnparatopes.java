package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.f1357_mostrargnparatopes", "/web.f1357_mostrargnparatopes"})
public final  class f1357_mostrargnparatopes extends GXWebObjectStub
{
   public f1357_mostrargnparatopes( )
   {
   }

   public f1357_mostrargnparatopes( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( f1357_mostrargnparatopes.class ));
   }

   public f1357_mostrargnparatopes( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new f1357_mostrargnparatopes_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new f1357_mostrargnparatopes_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Composición de ganancia neta para topes";
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

