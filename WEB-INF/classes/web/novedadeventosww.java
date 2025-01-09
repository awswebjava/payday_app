package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.novedadeventosww", "/web.novedadeventosww"})
public final  class novedadeventosww extends GXWebObjectStub
{
   public novedadeventosww( )
   {
   }

   public novedadeventosww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( novedadeventosww.class ));
   }

   public novedadeventosww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new novedadeventosww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new novedadeventosww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Novedad Eventos";
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

