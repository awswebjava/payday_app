package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.f1357_mostrardeterminado", "/web.f1357_mostrardeterminado"})
public final  class f1357_mostrardeterminado extends GXWebObjectStub
{
   public f1357_mostrardeterminado( )
   {
   }

   public f1357_mostrardeterminado( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( f1357_mostrardeterminado.class ));
   }

   public f1357_mostrardeterminado( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new f1357_mostrardeterminado_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new f1357_mostrardeterminado_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Composición del impuesto determinado";
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

