package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paistipotrabajo", "/web.paistipotrabajo"})
public final  class paistipotrabajo extends GXWebObjectStub
{
   public paistipotrabajo( )
   {
   }

   public paistipotrabajo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paistipotrabajo.class ));
   }

   public paistipotrabajo( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paistipotrabajo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paistipotrabajo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Tipo Trabajo";
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

