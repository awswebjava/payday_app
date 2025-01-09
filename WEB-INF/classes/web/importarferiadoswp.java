package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importarferiadoswp", "/web.importarferiadoswp"})
public final  class importarferiadoswp extends GXWebObjectStub
{
   public importarferiadoswp( )
   {
   }

   public importarferiadoswp( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importarferiadoswp.class ));
   }

   public importarferiadoswp( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importarferiadoswp_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importarferiadoswp_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importar Feriados WP";
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

