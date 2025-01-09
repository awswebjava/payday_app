package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_tiposdetrabajoww", "/web.empresa_tiposdetrabajoww"})
public final  class empresa_tiposdetrabajoww extends GXWebObjectStub
{
   public empresa_tiposdetrabajoww( )
   {
   }

   public empresa_tiposdetrabajoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_tiposdetrabajoww.class ));
   }

   public empresa_tiposdetrabajoww( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_tiposdetrabajoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_tiposdetrabajoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " empresa_tiposdetrabajo";
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

