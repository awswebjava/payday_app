package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paistipotrabajogeneral", "/web.paistipotrabajogeneral"})
public final  class paistipotrabajogeneral extends GXWebObjectStub
{
   public paistipotrabajogeneral( )
   {
   }

   public paistipotrabajogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paistipotrabajogeneral.class ));
   }

   public paistipotrabajogeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paistipotrabajogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paistipotrabajogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Tipo Trabajo General";
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

