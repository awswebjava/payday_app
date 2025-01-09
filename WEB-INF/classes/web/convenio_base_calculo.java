package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_base_calculo", "/web.convenio_base_calculo"})
public final  class convenio_base_calculo extends GXWebObjectStub
{
   public convenio_base_calculo( )
   {
   }

   public convenio_base_calculo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_base_calculo.class ));
   }

   public convenio_base_calculo( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_base_calculo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_base_calculo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Convenio_base_calculo";
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

