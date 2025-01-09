package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.modalidadgeneral", "/web.modalidadgeneral"})
public final  class modalidadgeneral extends GXWebObjectStub
{
   public modalidadgeneral( )
   {
   }

   public modalidadgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( modalidadgeneral.class ));
   }

   public modalidadgeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new modalidadgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new modalidadgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Modalidad General";
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

