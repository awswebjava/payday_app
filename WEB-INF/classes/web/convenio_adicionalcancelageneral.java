package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalcancelageneral", "/web.convenio_adicionalcancelageneral"})
public final  class convenio_adicionalcancelageneral extends GXWebObjectStub
{
   public convenio_adicionalcancelageneral( )
   {
   }

   public convenio_adicionalcancelageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalcancelageneral.class ));
   }

   public convenio_adicionalcancelageneral( int remoteHandle ,
                                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalcancelageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalcancelageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional Cancela General";
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

