package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.escolaridad", "/web.escolaridad"})
public final  class escolaridad extends GXWebObjectStub
{
   public escolaridad( )
   {
   }

   public escolaridad( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( escolaridad.class ));
   }

   public escolaridad( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new escolaridad_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new escolaridad_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Escolaridad";
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
      return "escolaridad_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

