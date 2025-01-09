package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_horasextras_pordiaww", "/web.convenio_horasextras_pordiaww"})
public final  class convenio_horasextras_pordiaww extends GXWebObjectStub
{
   public convenio_horasextras_pordiaww( )
   {
   }

   public convenio_horasextras_pordiaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_horasextras_pordiaww.class ));
   }

   public convenio_horasextras_pordiaww( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_horasextras_pordiaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_horasextras_pordiaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Convenio_horasextras_por Dia";
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

