package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.editarformula", "/web.editarformula"})
public final  class editarformula extends GXWebObjectStub
{
   public editarformula( )
   {
   }

   public editarformula( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( editarformula.class ));
   }

   public editarformula( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new editarformula_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new editarformula_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Editar Fórmula";
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
