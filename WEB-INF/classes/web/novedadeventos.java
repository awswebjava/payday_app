package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.novedadeventos", "/web.novedadeventos"})
public final  class novedadeventos extends GXWebObjectStub
{
   public novedadeventos( )
   {
   }

   public novedadeventos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( novedadeventos.class ));
   }

   public novedadeventos( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new novedadeventos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new novedadeventos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Novedad Eventos";
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

