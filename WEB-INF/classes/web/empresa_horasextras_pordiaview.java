package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_horasextras_pordiaview", "/web.empresa_horasextras_pordiaview"})
public final  class empresa_horasextras_pordiaview extends GXWebObjectStub
{
   public empresa_horasextras_pordiaview( )
   {
   }

   public empresa_horasextras_pordiaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_horasextras_pordiaview.class ));
   }

   public empresa_horasextras_pordiaview( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_horasextras_pordiaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_horasextras_pordiaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa_horasextras_por Dia View";
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

