package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicional_importes", "/web.convenio_adicional_importes"})
public final  class convenio_adicional_importes extends GXWebObjectStub
{
   public convenio_adicional_importes( )
   {
   }

   public convenio_adicional_importes( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicional_importes.class ));
   }

   public convenio_adicional_importes( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicional_importes_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicional_importes_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Convenio_Adicional_Importes";
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

