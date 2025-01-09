package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paistipotrabajoww", "/web.paistipotrabajoww"})
public final  class paistipotrabajoww extends GXWebObjectStub
{
   public paistipotrabajoww( )
   {
   }

   public paistipotrabajoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paistipotrabajoww.class ));
   }

   public paistipotrabajoww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paistipotrabajoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paistipotrabajoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Pais Tipo Trabajo";
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

